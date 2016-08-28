import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { routing } from './app.routing';
import { AppComponent }  from './app.component';
import { HomeComponent} from './home/home.component';
import { ShowEventsComponent }     from './showevent/showevents.component';
//import { ShowEventService } from './show/showevent/showevents.service'

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        routing
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        ShowEventsComponent
    ],
    // providers: [
    //     ShowEventsService
    // ],
    bootstrap: [ AppComponent ]
})
export class AppModule {
}