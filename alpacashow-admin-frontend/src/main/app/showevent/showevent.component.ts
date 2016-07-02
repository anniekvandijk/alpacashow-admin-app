import { Component } from '@angular/core';
import { NewShow } from './newshowevent.components';

@Component({
    selector: 'showevent',
    templateUrl: './app/showevent/showevent.html',
    directives: [ NewShow ]
})

export class ShowEventComponent {
}
