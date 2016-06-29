import { Component } from '@angular/core';
import {RouterConfig, provideRouter} from '@angular/router';
import {HomeComponent} from "../home/home.component";
import {ShowEventComponent} from "../showevent/showevent.component";

@Component({
    selector: 'navigation',
    templateUrl: 'app/navigation/navigation.html'
})


export const routes: RouterConfig = [
    { path: '', redirectTo: 'home'},
    { path: 'Home', component: HomeComponent},
    { path: 'Show', component: ShowEventComponent},
];

export class NavigationComponent {
}

export const APP_ROUTER_PROVIDERS = [
    provideRouter(routes)
];