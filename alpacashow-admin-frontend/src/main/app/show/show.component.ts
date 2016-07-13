import { Component } from '@angular/core';
import { ShowEventForm } from './newshowevent/newshowevent-form.component';
import { ShowEventComponent } from './showevent/showevent.component';


@Component({
    selector: 'show',
    templateUrl: './app/show/show.html',
    directives: [ ShowEventForm, ShowEventComponent ]
})

export class ShowComponent {
}
