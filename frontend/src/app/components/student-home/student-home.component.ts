import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'app/model/Student';
import { StudentService } from 'app/services/student.service';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent {

  studentId: number = 0;
  student: any;

  constructor(private route: ActivatedRoute, private router: Router, private studentService: StudentService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.studentId = +params['id'];
      this.loadStudent(this.studentId);
    });
  }

  loadStudent(id: number): void {
    this.studentService.getStudentById(47).subscribe((data: Student) => {
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
  }
}
