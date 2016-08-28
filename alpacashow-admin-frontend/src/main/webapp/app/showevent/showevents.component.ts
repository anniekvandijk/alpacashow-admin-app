import { Component } from '@angular/core';
import { ShowEvent } from './showevent';
import { ShowEventService } from './showevent.service';

@Component({
    selector: 'showevents',
    templateUrl: './app/showevent/showevents.html',
    providers: [ShowEventService]

})

export class ShowEventsComponent {

    showevents: ShowEvent[];
    deleteMessage = '';
    updateMessage = '';

    constructor(private showEventService: ShowEventService) { }

    getShowEvents() {
        this.showEventService.getShowEvents().then(showevents => this.showevents = showevents);
    }
    ngOnInit() {
        this.getShowEvents();
    }

    deleteShow() {
        this.deleteMessage = 'Show delete!';
    }

    updateShow() {
        this.updateMessage = 'Show update!';
    }

}