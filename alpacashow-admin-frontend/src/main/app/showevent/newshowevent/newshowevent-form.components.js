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
var newshowevent_1 = require('./newshowevent');
var ShowEventForm = (function () {
    function ShowEventForm() {
        this.submitted = false;
        this.active = true;
        this.model = new newshowevent_1.NewShowEvent('', '', '', '', '', false, false, false, false);
    }
    ShowEventForm.prototype.onSubmit = function (form) {
        this.submitted = true;
        //    this.active = false;
        //   setTimeout(() => this.active = true, 0);
        console.log('you submitted value:', form);
        console.log('json: ', JSON.stringify(this.model));
        // json sent to backend
    };
    ShowEventForm = __decorate([
        core_1.Component({
            selector: 'new-showevent-form',
            templateUrl: './app/showevent/newshowevent/newshowevent-form.html',
        }), 
        __metadata('design:paramtypes', [])
    ], ShowEventForm);
    return ShowEventForm;
}());
exports.ShowEventForm = ShowEventForm;
//# sourceMappingURL=newshowevent-form.components.js.map