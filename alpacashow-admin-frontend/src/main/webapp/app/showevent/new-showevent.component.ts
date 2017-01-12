import { Component } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';

@Component({
    selector: 'new-showevent',
    templateUrl: './app/showevent/new-showevent.html',
    providers: [ FormBuilder ],
})

export class NewShowEventComponent {

    submitted = false;
    active = true;

    constructor(private formBuilder: FormBuilder) {}

    newShowEventForm: FormGroup;

    ngOnInit() {
        this.newShowEventForm = this.formBuilder.group({
            name:               ['', Validators.required],
            location:           ['', Validators.required],
            date:               ['', Validators.required],
            closeDate:          ['', Validators.required],
            judge:              ['', Validators.required],
            showType:           ['', Validators.required],
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