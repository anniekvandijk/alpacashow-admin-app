import { Injectable } from '@angular/core';
import { SHOWEVENTS } from './showevents-mock';

@Injectable()
export class ShowEventService {
    getShowEvents() {
        return Promise.resolve(SHOWEVENTS);
    }
}


// import { Injectable }    from '@angular/core';
// import { Headers, Http } from '@angular/http';
//
// import 'rxjs/add/operator/toPromise';
//
// import { ShowEvent } from './showevent';
//
// @Injectable()
// export class ShowEventService {
//
//     private headers = new Headers({'Content-Type': 'application/json'});
//     private showEventUrl = 'http://localhost:8081/webservice/showevents';  // URL to web api
//
//     constructor(private http: Http) { }
//
//     getShowEvents(): Promise<ShowEvent[]> {
//         return this.http.get(this.showEventUrl)
//             .toPromise()
//             .then(response => response.json().data as ShowEvent[])
//             .catch(this.handleError);
//     }
//
//     private handleError(error: any): Promise<any> {
//         console.error('An error occurred', error); // for demo purposes only
//         return Promise.reject(error.message || error);
//     }
// }