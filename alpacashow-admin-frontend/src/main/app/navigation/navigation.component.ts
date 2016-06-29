import { Component } from '@angular/core';
import {RouterConfig, provideRouter, ROUTER_DIRECTIVES} from '@angular/router';
import {ShowEventComponent} from "../showevent/showevent.component";
import { HomeComponent } from '../home/home.component';
import {AppComponent} from "../app.component";

@Component({
    selector: 'navigation',
    template: `
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" [routerLink]="['Home']">Home</a>
                <a class="navbar-brand" [routerLink]="['Show']">Show</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="https://github.com/anniekvandijk/alpacashow-admin-app">Github</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="content">
            <router-outlet></router-outlet>
        </div>
    </div>`,
    directives: ROUTER_DIRECTIVES
})

 export class NavigationComponent {
 }

export const routes: RouterConfig = [
    { path: '', component: AppComponent},
    { path: 'Home', component: HomeComponent},
    { path: 'Show', component: ShowEventComponent},
];

export const APP_ROUTER_PROVIDERS = [
    provideRouter(routes)
];
