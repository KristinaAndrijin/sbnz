import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialogModule } from '@angular/material/dialog';
import { MatRadioModule } from '@angular/material/radio';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { StudentHomeComponent } from './components/student-home/student-home.component';
import { AdminEditStudentComponent } from './components/admin-edit-student/admin-edit-student.component';
import { EditSubjectsComponent } from './dialogs/edit-subjects/edit-subjects.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { EditTraitsComponent } from './dialogs/edit-traits/edit-traits.component';
import { LearningMethodDialogComponent } from './dialogs/learning-method-dialog/learning-method-dialog.component';
@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    NavbarComponent,
    LoginComponent,
    StudentHomeComponent,
    AdminEditStudentComponent,
    EditSubjectsComponent,
    EditTraitsComponent,
    LearningMethodDialogComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    MatCheckboxModule,
    MatDialogModule,
    MatRadioModule
  ],
  providers: [
    provideAnimationsAsync('noop')
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
