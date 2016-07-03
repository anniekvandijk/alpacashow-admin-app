import { Component } from '@angular/core';
import { NewShowEvent} from './newshowevent';


@Component({
    selector: 'new-showevent-form',
    templateUrl: './app/showevent/newshowevent/newshowevent-form.html',
})

export class ShowEventForm {

    submitted = false;
    active = true;

    model = new NewShowEvent('', '', '', '', '', false, false, false, false);

    onSubmit(form:any):void {
        this.submitted = true;
        //    this.active = false;
        //   setTimeout(() => this.active = true, 0);
        console.log('you submitted value:', form);
        console.log('json: ', JSON.stringify(this.model));
        
        // json sent to backend
    }
}