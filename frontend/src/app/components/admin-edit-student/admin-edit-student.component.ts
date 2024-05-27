import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-edit-student',
  templateUrl: './admin-edit-student.component.html',
  styleUrl: './admin-edit-student.component.css'
})
export class AdminEditStudentComponent {
  studentId: number = 0;
  // student: any; 

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.studentId = +params['id'];
      // this.student = this.findStudentById(this.studentId); //iz servisa
    });
  }
  
  student = {
    id: 1,
    name: 'John',
    surname: 'Doe',
    subjects: ['Math', 'Science', 'History'],
    field: 'Natural Science',
    personalityTraits: ['Extravert', 'Creative'],
    learningMethods: ['Auditory', 'Verbal']
  };

  backToAllStudents() {
    this.router.navigate(['/admin-home']); // Ispravljena putanja
  }

  editSubject() {
    
  }
}
