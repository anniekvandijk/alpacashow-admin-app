import { Component } from '@angular/core';
import { FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup } from '@angular/forms';

export class ShowType {
    name: string;
    label: string;
    value: boolean;
}

const SHOWTYPES: ShowType[] = [
    { value: false, name: 'haltershow', label: 'Haltershow' },
    { value: false, name: 'fleeceshow', label: 'Fleeceshow' },
    { value: false, name: 'maleprogenyshow', label: 'Male progeny show' },
    { value: false, name: 'femaleprogenyshow', label: 'Female progeny show' }

];

@Component({
    selector: 'new-showevent',
    templateUrl: './app/showevent/new-showevent.html',
    providers: [ FormBuilder ],
    directives: [FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES],
})

export class NewShowEventComponent {
    
    showtypes = SHOWTYPES;
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