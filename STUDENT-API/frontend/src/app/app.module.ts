import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudentComponentComponent } from './student-component/student-component.component';
import { HttpClientModule } from '@angular/common/http';
import { StudentService } from './student.service';


@NgModule({
  declarations: [
    AppComponent,
    StudentComponentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
