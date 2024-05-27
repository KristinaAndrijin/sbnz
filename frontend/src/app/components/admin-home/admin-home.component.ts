import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  students = [
    {
      id: 1,
      name: 'John',
      surname: 'Doe',
      subjects: ['Math', 'Science', 'History'],
      field: 'Natural Science',
      personalityTraits: ['Extravert', 'Creative'],
      learningMethods: ['Auditory', 'Verbal']
    },
    {
      id: 2,
      name: 'John2',
      surname: 'Doe2',
      subjects: ['Math', 'Science', 'History'],
      field: 'Natural Science',
      personalityTraits: ['Extravert', 'Creative'],
      learningMethods: ['Auditory', 'Verbal']
    }
  ];

  constructor(private router: Router) {}

  redirectToEditStudent(studentId: number) {
    this.router.navigate(['/admin-edit-student', studentId]); // Ispravljena putanja
  }
}
