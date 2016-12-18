import './rxjs-extensions';
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { routing } from './app.routing';
import { AppComponent }  from './app.component';
import { HomeComponent} from './home/home.component';
import { ShowEventsComponent }     from './showevent/showevents.component';
import { NewShowEventComponent }     from './showevent/new-showevent.component';
import { HttpModule }    from '@angular/http';
import { ShowEventService } from './showevent/showevent.service';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        routing,
        HttpModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        ShowEventsComponent,
        NewShowEventComponent
    ],
    providers: [ ShowEventService ],
    bootstrap: [ AppComponent ]
})
export class AppModule {
}