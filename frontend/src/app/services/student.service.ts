import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LearningMethod, Student } from 'app/model/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiUrl = 'http://localhost:8080/students';

  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.apiUrl);
  }

  getStudentById(id: number): Observable<Student> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Student>(url);
  }

  updateStudentSubjects(studentId: number, selectedSubjects: any[]): Observable<any> {
    const url = `${this.apiUrl}/${studentId}/subjects`;
    return this.http.put(url, selectedSubjects);
  }

  updateStudentTraits(studentId: number, selectedTraits: any[]): Observable<any> {
    const url = `${this.apiUrl}/${studentId}/traits`;
    return this.http.put(url, selectedTraits);
  }

  getLearningMethodsForward1(id: number): Observable<LearningMethod[]> {
    const url = `${this.apiUrl}/${id}/forward1`;
    return this.http.get<LearningMethod[]>(url);
  }

  getLearningMethodsForward2(id: number): Observable<LearningMethod[]> {
    const url = `${this.apiUrl}/${id}/forward2`;
    return this.http.get<LearningMethod[]>(url);
  }

  getLearningMethodsForward12(id: number): Observable<LearningMethod[]> {
    const url = `${this.apiUrl}/${id}/forward12`;
    return this.http.get<LearningMethod[]>(url);
  }
  getLearningMethodsBackward(id: number, method: LearningMethod): Observable<boolean> {
    const url = `${this.apiUrl}/${id}/backward?method=${method}`;
    return this.http.get<boolean>(url);
  }
  
  getReport1(): Observable<LearningMethod[]> {
    const url = `${this.apiUrl}/getReport1`;
    return this.http.get<LearningMethod[]>(url);
  }

  getReport2(): Observable<LearningMethod[]> {
    return this.http.get<LearningMethod[]>(this.apiUrl+"/getReport1"    );
  }
  
}
