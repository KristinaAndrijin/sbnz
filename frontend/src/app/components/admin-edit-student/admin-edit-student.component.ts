import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'app/services/student.service'; 
import { Student } from 'app/model/Student';

@Component({
  selector: 'app-admin-edit-student',
  templateUrl: './admin-edit-student.component.html',
  styleUrl: './admin-edit-student.component.css'
})
export class AdminEditStudentComponent {
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
    this.studentService.getStudentById(id).subscribe((data: Student) => {
      this.student = data;
      console.log('Loaded student:', this.student); 
    }, error => {
      console.error('Error loading student:', error);
    });
  }
  

  backToAllStudents() {
    this.router.navigate(['/admin-home']);
  }

  editSubject() {
    
  }
}
