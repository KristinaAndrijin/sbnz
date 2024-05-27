import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) { }

  login() {
    if (this.username === 'admin' && this.password === 'admin') {
      this.router.navigate(['/admin-home']);
    } else if (this.username === 'student' && this.password === 'student') {
      this.router.navigate(['/student-home']);
    } else {
      alert('Invalid username or password');
    }
  }
}
