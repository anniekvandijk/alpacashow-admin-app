import { Component } from '@angular/core';
import './rxjs-extensions';
import { ToArrayPipe } from "./arraypipe";

@Component({
  selector: 'my-app',
  templateUrl: './app/app.html',
  pipes: [ ToArrayPipe ]
})

export class AppComponent { }
