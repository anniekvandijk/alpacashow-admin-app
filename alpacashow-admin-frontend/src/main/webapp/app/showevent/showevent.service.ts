import { Injectable } from '@angular/core';
import { SHOWEVENTS } from './showevents-mock';

@Injectable()
export class ShowEventService {
    getShowEvents() {
        return Promise.resolve(SHOWEVENTS);
    }
}