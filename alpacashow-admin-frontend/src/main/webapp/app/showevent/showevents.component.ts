import { Component }                from '@angular/core';
import { REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { ShowEvent }                from './showevent';
import { NewShowEventComponent }    from "./new-showevent.component";
import { ShowEventService }         from './showevent.service';

@Component({
    selector: 'showevents',
    templateUrl: './app/showevent/showevents.html',
    providers: [ShowEventService, FormBuilder],
    directives: [NewShowEventComponent, REACTIVE_FORM_DIRECTIVES]

})

export class ShowEventsComponent {

    selectedShow: ShowEvent;
    updateShowEventForm: FormGroup;
    showevents: ShowEvent[];
    deleteMessage = '';

    constructor(private showEventService: ShowEventService, private formBuilder: FormBuilder) { }

    getShowEvents() {
        this.showEventService.getShowEvents().then(showevents => this.showevents = showevents);
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

    onSelect(showevent: ShowEvent): void {

        this.selectedShow = showevent;
    }

    deleteShow() {
        this.deleteMessage = 'Show delete!';
    }

}