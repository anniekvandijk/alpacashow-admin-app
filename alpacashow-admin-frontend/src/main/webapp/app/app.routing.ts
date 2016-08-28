import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent} from './home/home.component';
import { ShowComponent }     from './show/show.component';

const appRoutes: Routes = [

    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },

    {
        path: 'home',
        component: HomeComponent
    },

    {
        path: 'show',
        component: ShowComponent
    }
];


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
