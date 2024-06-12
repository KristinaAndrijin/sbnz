import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { StudentHomeComponent } from './components/student-home/student-home.component';
import { AdminEditStudentComponent } from './components/admin-edit-student/admin-edit-student.component';

const routes: Routes = [

    {
        path: '',
        component: LoginComponent,
    },
    { path: 'login', component: LoginComponent },
    { path: 'admin-home', component: AdminHomeComponent },
    { path: 'student-home', component: StudentHomeComponent },
    { path: 'admin-edit-student/:id', component: AdminEditStudentComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
