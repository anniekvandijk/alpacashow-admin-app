import { Component } from '@angular/core';


@Component({
    selector: 'new-showevent',
    templateUrl: './app/showevent/newshowevent.html',
})

export class NewShow {
    onSubmit(form: any): void {
        console.log('you submitted value:', form);
    }
}