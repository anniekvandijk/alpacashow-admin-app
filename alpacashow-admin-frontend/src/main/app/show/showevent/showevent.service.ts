import { Injectable } from '@angular/core';
import { ShowEvent } from './showevent';
import { SHOWEVENTS } from './showevent-mock';

@Injectable()
export class ShowEventService {
    getShowEvents() {
        return Promise.resolve(SHOWEVENTS);
    }
}