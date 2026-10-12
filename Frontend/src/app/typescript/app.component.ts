import { Component } from '@angular/core';
import {Top} from './header'
import {Aside} from './aside';
import {Planner} from './planner';
import {Trips} from './trips';

@Component({
  selector: 'app-root',
  imports: [Top, Planner, Trips, Aside],
  templateUrl: '../html/app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';
}
