import { Component } from '@angular/core';
import {Top} from './header'
import {Header} from './aside';
import {Planner} from './planner';
import {Trips} from './trips';

@Component({
  selector: 'app-root',
  imports: [Top, Header, Planner, Trips],
  templateUrl: '../html/app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Frontend';
}
