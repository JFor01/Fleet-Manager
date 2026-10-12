import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/typescript/app.config';
import { AppComponent } from './app/typescript/app.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
