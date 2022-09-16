import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

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
        console.log(response);
      },
      (err: HttpErrorResponse) => {
        alert(err.message);
      }
    );
  }
  public onAddEmployee(addForm: NgForm): void {
    console.log(addForm.value);
  }

  public onOpenModal(mode: String, employee?: Employee): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    let target = '';
    console.log(employee);

    switch (mode) {
      case 'add':
        target = 'addEmployeeModal';
        break;
      case 'edit':
        target = 'editEmployeeModal';
        break;
      case 'delete':
        target = 'deleteEmployeeModal';
        break;
    }
    button.setAttribute('data-target', `#${target}`);
    container?.appendChild(button);
    button.click();
  }
}
