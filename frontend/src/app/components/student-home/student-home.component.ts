import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { EditTraitsComponent } from 'app/dialogs/edit-traits/edit-traits.component';
import { Student } from 'app/model/Student';
import { StudentService } from 'app/services/student.service';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent {
  isDialogOpen: boolean = false;
  studentId: number = 99;
  student: any;

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.studentId = +params['id'];
      this.loadStudent(this.studentId);
    });
  }

  loadStudent(id: number): void {
    this.studentService.getStudentById(99).subscribe((data: Student) => {
      this.student = data;
      console.log('Loaded student:', this.student);
    }, error => {
      console.error('Error loading student:', error);
    });
  }

  requestLearningMethod() {

  }

  chooseLearningMethod() {

  }

  setPersonalityTraits() {
    const dialogRef = this.dialog.open(EditTraitsComponent, {
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
      console.log('Selected traits:', result);
      this.isDialogOpen = false;
      this.updateStudentTraits(result);
    });
  }

  updateStudentTraits(selectedTraits: any[]): void {
    this.studentService.updateStudentTraits(99, selectedTraits).subscribe(() => {
      console.log('Student traits updated successfully.');
      this.loadStudent(this.studentId);
    }, error => {
      console.error('Error updating student traits:', error);
    });
  }
}

