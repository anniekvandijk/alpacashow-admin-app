import { Component } from '@angular/core';
import { ShowEventForm } from './newshowevent/newshowevent-form.components';


@Component({
    selector: 'show',
    templateUrl: './app/show/show.html',
    directives: [ ShowEventForm ]
})

export class ShowComponent {
}
