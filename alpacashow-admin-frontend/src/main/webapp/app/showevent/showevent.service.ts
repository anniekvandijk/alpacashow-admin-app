// import { Injectable } from '@angular/core';
// import { SHOWEVENTS } from './showevents-mock';
//
// @Injectable()
// export class ShowEventService {
//     getShowEvents() {
//         return Promise.resolve(SHOWEVENTS);
//     }
// }

import { Injectable }    from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/add/operator/toPromise';
import {ShowEvent} from "../model/showevent";

@Injectable()
export class ShowEventService {

    // private headers = new Headers({'Content-Type': 'application/json'});
    private showEventUrl = 'http://localhost:8081/webservice/showevents';

    constructor (private http: Http) {}

    getShowEvents (): Observable<ShowEvent[]> {
        return this.http.get(this.showEventUrl)
            .map(this.extractData)
            .catch(this.handleError);
    }
    private extractData(res: Response) {
        let body = res.json();
        return body.data || { };
    }
    private handleError (error: Response | any) {
        // In a real world app, we might use a remote logging infrastructure
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }
}