import { Component }                from '@angular/core';
import { REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import * as models                  from '../model/models';
import { NewShowEventComponent }    from "./new-showevent.component";
import { ShowEventService }         from './showevent.service';

@Component({
    selector: 'showevents',
    templateUrl: './app/showevent/showevents.html',
    providers: [ShowEventService, FormBuilder],
    directives: [NewShowEventComponent, REACTIVE_FORM_DIRECTIVES]
})

export class ShowEventsComponent {

    selectedShow: models.ShowEvent;
    updateShowEventForm: FormGroup;
    showevents: models.ShowEvent[];
    deleteMessage = '';

    constructor(private showEventService: ShowEventService, private formBuilder: FormBuilder) { }

    getShowEvents() {
        this.showEventService.getShowEvents().forEach(events => this.showevents = events);
    }
    ngOnInit() {
        this.getShowEvents();

        this.updateShowEventForm = this.formBuilder.group({
            name:               ['', Validators.required],
            location:           ['', Validators.required],
            date:               ['', Validators.required],
            closeDate:          ['', Validators.required],
            judge:              ['', Validators.required],
            shows:              ['', Validators.required],
        });
    }

    onSelect(showevent: models.ShowEvent): void {

        this.selectedShow = showevent;
    }

    deleteShow() {
        this.deleteMessage = 'Show delete!';
    }

}