import { Component } from '@angular/core';
import { FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup } from '@angular/forms';

export class ShowType {
    name: string;
    label: string;
}

const SHOWTYPES: ShowType[] = [
    { name: 'haltershow', label: 'Haltershow' },
    { name: 'fleeceshow', label: 'Fleeceshow' },
    { name: 'maleprogenyshow', label: 'Male progeny show' },
    { name: 'femaleprogenyshow', label: 'Female progeny show' }

];

@Component({
    selector: 'new-showevent-form',
    templateUrl: './app/showevent/newshowevent/newshowevent-form.html',
    directives: [FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES],
})

export class ShowEventForm {

    showtype = SHOWTYPES;
    submitted = false;
    active = true;

    constructor(private formBuilder: FormBuilder) {}

    showEventForm: FormGroup;

    ngOnInit() {
        this.showEventForm = this.formBuilder.group({
            name:               ['', Validators.required],
            location:           ['', Validators.required],
            date:               ['', Validators.required],
            closedate:          ['', Validators.required],
            judge:              ['', Validators.required],
            haltershow:         ['', ],
            fleeceshow:         ['', ],
            maleprogenyshow:    ['', ],
            femaleprogenyshow:  ['', ],

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