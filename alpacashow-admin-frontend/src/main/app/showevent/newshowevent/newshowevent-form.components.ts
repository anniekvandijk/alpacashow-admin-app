import { Component } from '@angular/core';
import { FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
    selector: 'new-showevent-form',
    templateUrl: './app/showevent/newshowevent/newshowevent-form.html',
    directives: [FORM_DIRECTIVES, REACTIVE_FORM_DIRECTIVES],
})

export class ShowEventForm {

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