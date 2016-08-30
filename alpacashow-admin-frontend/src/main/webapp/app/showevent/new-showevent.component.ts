import { Component } from '@angular/core';
import { REACTIVE_FORM_DIRECTIVES, FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';

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
    directives: [REACTIVE_FORM_DIRECTIVES],
})

export class NewShowEventComponent {

    showtypes = SHOWTYPES;
    submitted = false;
    showtypeSelected = false;
    active = true;
    selectedShowType = [];
    shows = this.selectedShowType;

    select(showtype){
        this.selectedShowType.push(showtype);
        this.showtypeSelected = true;
    }

    remove(showtype){
        this.selectedShowType.splice(this.selectedShowType.indexOf(showtype),1);
        this.showtypeSelected = false;

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