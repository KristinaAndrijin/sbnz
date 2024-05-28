import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'app/services/student.service'; 
import { Student, Subject } from 'app/model/Student';
import { EditSubjectsComponent } from 'app/dialogs/edit-subjects/edit-subjects.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-admin-edit-student',
  templateUrl: './admin-edit-student.component.html',
  styleUrl: './admin-edit-student.component.css'
})
export class AdminEditStudentComponent {
  isDialogOpen: boolean = false;
  studentId: number = 0;
  student: any; 

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
    this.studentId = +params['id'];
    this.loadStudent(this.studentId);
  });
  }
  
  loadStudent(id: number): void {
    this.studentService.getStudentById(id).subscribe((data: Student) => {
      this.student = data;
      console.log('Loaded student:', this.student); 
    }, error => {
      console.error('Error loading student:', error);
    });
  }
  

  backToAllStudents() {
    this.router.navigate(['/admin-home']);
  }

  editSubject(): void {
    const dialogRef = this.dialog.open(EditSubjectsComponent, {
      width: '250px',
      panelClass: 'custom-dialog-container',
      backdropClass: 'backdrop-blur',
      data: { studentId: this.studentId },
    });

    dialogRef.afterOpened().subscribe(() => {
      this.isDialogOpen = true;
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log('Selected subjects:', result);
      this.isDialogOpen = false;
      this.updateStudentSubjects(result);
    });
  }

  updateStudentSubjects(selectedSubjects: any[]): void {
    this.studentService.updateStudentSubjects(this.studentId, selectedSubjects).subscribe(() => {
      console.log('Student subjects updated successfully.');
      this.loadStudent(this.studentId);
    }, error => {
      console.error('Error updating student subjects:', error);
    });
  }
}
