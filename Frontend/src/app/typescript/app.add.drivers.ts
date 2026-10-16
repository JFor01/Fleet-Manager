import {Component, inject, signal} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgOptimizedImage} from '@angular/common';
import {DriverService} from './services/DriverService';
import {ConsoleLogger} from '@angular/compiler-cli';


@Component({
  selector : 'Add-drivers-form',
  templateUrl : '../html/add-drivers-form.html',
  imports: [ReactiveFormsModule],
})
export class AddDriversForm{
  protected name = new FormControl('');
  private driverService = inject(DriverService);
  public message = signal("");
  public addFlag = signal(false);

  protected addDriverForm = new FormGroup({
    name : new FormControl('', Validators.required),
    age : new FormControl(null, [Validators.required, Validators.min(18)])
  })

  protected addDriver(){
    if (this.addDriverForm.invalid ){
      this.message.set("Button error")
      return
    }
    const driver = this.addDriverForm.getRawValue()
    if (driver.name === null || driver.age ===null){
      this.message.set("Button error")
      return
    }
    this.driverService.add({name : driver.name ,age : driver.age, active:false }).subscribe(newDriver =>
      (this.driverService.appendDriver(newDriver)));
  }

  protected readonly signal = signal;
}
