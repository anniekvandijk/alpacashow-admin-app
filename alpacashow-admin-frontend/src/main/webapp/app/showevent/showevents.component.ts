import {Component, OnInit}                from '@angular/core';
import { REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { NewShowEventComponent }    from "./new-showevent.component";
import { ShowEventService }         from './showevent.service';
import {ShowEvent}                  from "../model/showevent";

@Component({
    selector: 'showevents',
    templateUrl: './app/showevent/showevents.html',
    providers: [ShowEventService, FormBuilder],
    directives: [NewShowEventComponent, REACTIVE_FORM_DIRECTIVES],
})

export class ShowEventsComponent implements OnInit {

    errorMessage: string;
    selectedShow: ShowEvent;
    updateShowEventForm: FormGroup;
    showevents: ShowEvent[];
    deleteMessage = 'None';

    constructor(private showEventService: ShowEventService, private formBuilder: FormBuilder) { }

    getShowEvents() {
        this.showEventService.getShowEvents()
            .subscribe(
                showevents => this.showevents = showevents,
                error =>  this.errorMessage = <any>error);
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