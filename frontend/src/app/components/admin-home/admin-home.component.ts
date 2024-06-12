import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LearningMethod, Student } from 'app/model/Student';
import { StudentService } from 'app/services/student.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  students :Student[] = [];
  learningMethods: LearningMethod[] = [];

  constructor(private router: Router, private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.getAllStudents().subscribe((data: Student[]) => {
      this.students = data;
    });
  }

  redirectToEditStudent(studentId: number) {
    this.router.navigate(['/admin-edit-student', studentId]); 
  }

  getReport1(){
    this.studentService.getReport1().subscribe((data2: LearningMethod[]) => {
      this.learningMethods = data2;
      console.log("avs");
      console.log(this.learningMethods);
      console.log("avs");
    });
  }

  getReport2(){
    
  }
}
