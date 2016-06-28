import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import { NavigationComponent, APP_ROUTER_PROVIDERS} from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'my-app',
  templateUrl: 'app/app.html',
  directives: [
    ...ROUTER_DIRECTIVES,
    NavigationComponent,
    HomeComponent
  ],
  providers: APP_ROUTER_PROVIDERS
})

export class AppComponent { }