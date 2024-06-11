import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { LearningMethod } from 'app/model/Student';

@Component({
  selector: 'app-learning-method-dialog',
  templateUrl: './learning-method-dialog.component.html',
  styleUrls: ['./learning-method-dialog.component.css']
})
export class LearningMethodDialogComponent {
  learningMethods = Object.values(LearningMethod);
  selectedMethod: string | undefined;

  constructor(
    public dialogRef: MatDialogRef<LearningMethodDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmSelection(): void {
    if (this.selectedMethod) {
      this.dialogRef.close(this.selectedMethod);
    }
  }
}
