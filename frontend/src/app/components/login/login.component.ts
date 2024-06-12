import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { LoginRequestDTO } from 'app/model/LoginRequestDTO';
import { AuthService } from 'app/services/auth.service';
import { NavigationExtras } from '@angular/router';
import { query } from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router, private cookieService: CookieService, private authService: AuthService) { }

  login() {
    let obj: LoginRequestDTO = {
      username: this.username,
      password: this.password
    }

    this.authService.login(obj).subscribe(
      (result) => {
        console.log(result)
        const cookieValue = this.cookieService.get('username');
        console.log('Value of myCookie:', cookieValue);
        alert('Successful!');
        if (this.username == 'admin') {
          this.router.navigate(['/admin-home']);
        } else {
          this.router.navigate(['/student-home'], { queryParams: { id: result }});
        }
        
      },
      (error) => {
        console.error(error);
        alert('aaaaaaaaaaaaa');
      }
    );
    // if (this.username === 'admin' && this.password === 'admin') {
    //   this.router.navigate(['/admin-home']);
    // } else if (this.username === 'student' && this.password === 'student') {
    //   this.router.navigate(['/student-home']);
    // } else {
    //   alert('Invalid username or password');
    // }
  }
}


