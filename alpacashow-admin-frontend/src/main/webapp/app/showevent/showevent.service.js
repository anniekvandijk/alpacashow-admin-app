"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var showevents_mock_1 = require('./showevents-mock');
var ShowEventService = (function () {
    function ShowEventService() {
    }
    ShowEventService.prototype.getShowEvents = function () {
        return Promise.resolve(showevents_mock_1.SHOWEVENTS);
    };
    ShowEventService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], ShowEventService);
    return ShowEventService;
}());
exports.ShowEventService = ShowEventService;
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
//# sourceMappingURL=showevent.service.js.map