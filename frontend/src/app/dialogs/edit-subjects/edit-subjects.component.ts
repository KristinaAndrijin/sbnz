import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SubjectName } from 'app/model/Student';

@Component({
  selector: 'app-edit-subjects',
  templateUrl: './edit-subjects.component.html',
  styleUrl: './edit-subjects.component.css'
})
export class EditSubjectsComponent {
  
  subjects: { name: string, subjectName: SubjectName, checked: boolean }[] = [
    { name: 'Physics', subjectName: SubjectName.PHYSICS, checked: false },
    { name: 'History', subjectName: SubjectName.HISTORY, checked: false },
    { name: 'English', subjectName: SubjectName.ENGLISH, checked: false },
    { name: 'Programming', subjectName: SubjectName.PROGRAMMING, checked: false },
    { name: 'Maths', subjectName: SubjectName.MATHS, checked: false },
    { name: 'Arts', subjectName: SubjectName.ARTS, checked: false }
  ];

  constructor(
    public dialogRef: MatDialogRef<EditSubjectsComponent>,
    @Inject(MAT_DIALOG_DATA) public data:  { studentId: number }
  ) {}

  onCancel(): void {
    this.dialogRef.close();
  }


  onConfirm(): void {
    if (this.data) { // Dodajte proveru da li je this.data definisan
      const selectedSubjects = this.subjects.filter(subject => subject.checked).map(subject => ({
        id: 0,
        name: subject.name,
        studentId: this.data.studentId,
        subjectName: subject.subjectName
      }));
      this.dialogRef.close(selectedSubjects);
    } else {
      console.error('Student data is not defined.');
    }
  }
  
}
