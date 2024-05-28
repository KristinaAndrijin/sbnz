import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { StudentHomeComponent } from './components/student-home/student-home.component';
import { AdminEditStudentComponent } from './components/admin-edit-student/admin-edit-student.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    NavbarComponent,
    LoginComponent,
    StudentHomeComponent,
    AdminEditStudentComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
