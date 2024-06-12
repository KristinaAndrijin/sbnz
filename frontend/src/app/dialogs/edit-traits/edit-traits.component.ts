import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { PersonalityTrait } from 'app/model/Student';

@Component({
  selector: 'app-edit-traits',
  templateUrl: './edit-traits.component.html',
  styleUrl: './edit-traits.component.css'
})
export class EditTraitsComponent {
  
  traits: { name: string, trait: PersonalityTrait, checked: boolean }[] = [
    { name: 'Extroverted', trait: PersonalityTrait.EXTROVERTED, checked: false },
    { name: 'Introverted', trait: PersonalityTrait.INTROVERTED, checked: false },
    { name: 'Analytical', trait: PersonalityTrait.ANALYTICAL, checked: false },
    { name: 'Creative', trait: PersonalityTrait.CREATIVE, checked: false },
    { name: 'Practical', trait: PersonalityTrait.PRACTICAL, checked: false },
    { name: 'Organized', trait: PersonalityTrait.ORGANIZED, checked: false },
    { name: 'Reflective', trait: PersonalityTrait.REFLECTIVE, checked: false }
  ];

  constructor(
    public dialogRef: MatDialogRef<EditTraitsComponent>,
    @Inject(MAT_DIALOG_DATA) public data:  { studentId: number }
  ) {}

  onCancel(): void {
    this.dialogRef.close();
  }

  onConfirm(): void {
    if (this.data) {
      const selectedTraits = this.traits
        .filter(trait => trait.checked)
        .map(trait => trait.trait); // Dodajte samo vrednost enumeracije u listu
  
      this.dialogRef.close(selectedTraits);
    } else {
      console.error('Student data is not defined.');
    }
  }
  
}
