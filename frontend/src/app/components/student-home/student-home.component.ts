import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { EditTraitsComponent } from 'app/dialogs/edit-traits/edit-traits.component';
import { LearningMethod, Student } from 'app/model/Student';
import { StudentService } from 'app/services/student.service';
import { LearningMethodDialogComponent } from 'app/dialogs/learning-method-dialog/learning-method-dialog.component';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent {
  isDialogOpen: boolean = false;
  studentId: number = 427;
  student: any;
  learningMethods: LearningMethod[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      // this.studentId = +params['id'];
      this.loadStudent(this.studentId);
      console.log(this.student.getLearningMethodsForward1());
    });
  }

  loadStudent(id: number): void {
    this.studentService.getStudentById(this.studentId).subscribe((data: Student) => {
      this.student = data;
      this.learningMethods = this.student.getLearningMethodsForward12;
      console.log('Loaded student:', this.student);
    }, error => {
      console.error('Error loading student:', error);
    });
  }

  requestLearningMethod1() {
    this.studentService.getLearningMethodsForward1(this.studentId).subscribe(
      (methods) => {
        this.learningMethods = [];
        this.learningMethods = methods;
        console.log(this.learningMethods);
        alert('Learning methods updated successfully!');
      },
      (error) => {
        console.error(error);
        alert('Failed to update learning methods.');
      }
    );
  }

  requestLearningMethod2() {
    this.studentService.getLearningMethodsForward2(this.studentId).subscribe(
      (methods) => {
        this.learningMethods = [];
        this.learningMethods = methods;
        console.log(this.learningMethods);
        alert('Learning methods updated successfully!');
      },
      (error) => {
        console.error(error);
        alert('Failed to update learning methods.');
      }
    );
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
    this.studentService.updateStudentTraits(this.studentId, selectedTraits).subscribe(() => {
      console.log('Student traits updated successfully.');
      this.loadStudent(this.studentId);
    }, error => {
      console.error('Error updating student traits:', error);
    });
  }

  chooseLearningMethod(): void {
    const dialogRef = this.dialog.open(LearningMethodDialogComponent, {
      width: '300px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateLearningMethod(result);
      }
    });
  }

  updateLearningMethod(method: LearningMethod): void {
    this.studentService.getLearningMethodsBackward(this.studentId, method).subscribe(
      (result: boolean) => {
        if (result) {
          this.learningMethods = [method];
          console.log('Learning method sent successfully.');
        } else {
          console.log('Learning method sent successfully.');
          alert('The method does not suit your personality type!');
        }
      },
      error => {
        console.error('Error sending learning method:', error);
      }
    );
  }

}

