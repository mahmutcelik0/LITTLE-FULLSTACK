import { Component } from '@angular/core';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-component',
  templateUrl: './student-component.component.html',
  styleUrls: ['./student-component.component.css']
})
export class StudentComponentComponent {
  studentService : StudentService;

  students :any;

  constructor(studentService: StudentService){
    this.studentService = studentService;
    
  }

  ngOnInit(){
    this.studentService.getStudents().subscribe(res => this.students = res);
  }
}