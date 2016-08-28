import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { routing } from './app.routing';
import { AppComponent }  from './app.component';
import { HomeComponent} from './home/home.component';
import { ShowComponent }     from './show/show.component';
//import { ShowEventService } from './show/showevent/showevent.service'

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        routing
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        ShowComponent
    ],
    // providers: [
    //     ShowEventService
    // ],
    bootstrap: [ AppComponent ]
})
export class AppModule {
}