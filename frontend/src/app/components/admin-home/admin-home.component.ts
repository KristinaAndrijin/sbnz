import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from 'app/model/Student';
import { StudentService } from 'app/services/student.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  students :Student[] = [];

  constructor(private router: Router, private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.getAllStudents().subscribe((data: Student[]) => {
      this.students = data;
    });
    console.log(this.students)
  }

  redirectToEditStudent(studentId: number) {
    this.router.navigate(['/admin-edit-student', studentId]); 
  }
}
