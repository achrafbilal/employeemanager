import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private apiServerUrl = '';
  constructor(private http: HttpClient) {}
  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee`);
  }
  public addEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/employee`, employee);
  }
  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/employee`, employee);
  }
  public deleteEmployee(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/employee/${id}`);
  }
}
