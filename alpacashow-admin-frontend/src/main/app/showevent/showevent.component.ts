import { Component } from '@angular/core';
import { ShowEventForm } from './newshowevent/newshowevent-form.components';


@Component({
    selector: 'showevent',
    templateUrl: './app/showevent/showevent.html',
    directives: [ ShowEventForm ]
})

export class ShowEventComponent {
}
