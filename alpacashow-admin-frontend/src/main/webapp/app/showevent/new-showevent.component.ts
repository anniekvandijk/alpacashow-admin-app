import { Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';

export class ShowType {
    showType: string;
}

const SHOWTYPES: ShowType[] = [
    { showType: 'Haltershow' },
    { showType: 'Fleeceshow' },
    { showType: 'Male progeny show' },
    { showType: 'Female progeny show' }

];

@Component({
    selector: 'new-showevent',
    templateUrl: './app/showevent/new-showevent.html',
    providers: [ FormBuilder ],
})

export class NewShowEventComponent {

    showtypes = SHOWTYPES;
    submitted = false;
    showtypeSelected = false;
    active = true;
    shows = [];

    // TODO change button collor when selected. After another click set default and remove showtype.

    select(showtype){
       this.shows.push(showtype);
    }

    remove(showtype){
        this.shows.splice(this.shows.indexOf(showtype),1);

    }

    constructor(private formBuilder: FormBuilder) {}

    newShowEventForm: FormGroup;

    ngOnInit() {
        this.newShowEventForm = this.formBuilder.group({
            name:               ['', Validators.required],
            location:           ['', Validators.required],
            date:               ['', Validators.required],
            closeDate:          ['', Validators.required],
            judge:              ['', Validators.required],
            shows:              ['', Validators.required],
        });
    }

    onSubmit(form:any):void {
        this.submitted = true;
        //    this.active = false;
        //   setTimeout(() => this.active = true, 0);
        console.log('you submitted value:', form);

        console.log('json output: ', JSON.stringify(form));
        
        // json sent to backend
    }
}