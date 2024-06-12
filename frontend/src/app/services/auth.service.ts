import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginRequestDTO } from 'app/model/LoginRequestDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) { }

  login(obj: LoginRequestDTO): Observable<any> {
    const url = `${this.apiUrl}/login`;
    return this.http.post(url, obj);
  }
}
