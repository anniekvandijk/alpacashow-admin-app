import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import { NavigationComponent} from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'my-app',
  templateUrl: 'app/app.html',
  directives: [
    ...ROUTER_DIRECTIVES,
    NavigationComponent,
    HomeComponent
  ]
})

export class AppComponent { }