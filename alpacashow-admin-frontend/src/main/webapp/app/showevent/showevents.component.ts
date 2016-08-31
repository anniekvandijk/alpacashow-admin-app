import { Component }                from '@angular/core';
import { ShowEvent }                from './showevent';
import { NewShowEventComponent }    from "./new-showevent.component";
import { ShowEventService }         from './showevent.service';

@Component({
    selector: 'showevents',
    templateUrl: './app/showevent/showevents.html',
    providers: [ShowEventService],
    directives: [NewShowEventComponent]

})

export class ShowEventsComponent {

    selectedShow: ShowEvent;

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

    onSelect(showevent: ShowEvent): void {
        this.selectedShow = showevent;
    }

    deleteShow() {
        this.deleteMessage = 'Show delete!';
    }

    updateShow() {
        this.updateMessage = 'Show update!';
    }

}