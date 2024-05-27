import { Component } from '@angular/core';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent {

  ngOnInit() {
    console.log(this.student.subjects);
  }
  
  student = {
    name: 'John',
    surname: 'Doe',
    subjects: ['Math', 'Science', 'History'],
    field: 'Natural Science',
    personalityTraits: ['Extravert', 'Creative'],
    learningMethods: ['Auditory', 'Verbal']
  };

  requestLearningMethod() {
    
  }

  chooseLearningMethod() {
    
  }
}
