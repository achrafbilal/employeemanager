import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  public employees: Employee[] = [];
  constructor(private employeeService: EmployeeService) {}
  ngOnInit() {
    this.getEmployees();
  }
  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
      }
    );
  }
}
