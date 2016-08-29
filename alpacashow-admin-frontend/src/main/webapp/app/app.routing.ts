import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent} from './home/home.component';
import {ShowEventsComponent} from "./showevent/showevents.component";
import {NewShowEventComponent} from "./showevent/new-showevent.component";

const appRoutes: Routes = [

    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'showevent', component: ShowEventsComponent },
    { path: 'showevent/new-showevent', component: NewShowEventComponent }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
