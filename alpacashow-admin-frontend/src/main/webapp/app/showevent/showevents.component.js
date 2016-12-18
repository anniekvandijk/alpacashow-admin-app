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
var forms_1 = require('@angular/forms');
var showevent_service_1 = require('./showevent.service');
var ShowEventsComponent = (function () {
    function ShowEventsComponent(showEventService, formBuilder) {
        this.showEventService = showEventService;
        this.formBuilder = formBuilder;
        this.deleteMessage = '';
    }
    ShowEventsComponent.prototype.getShowEvents = function () {
        var _this = this;
        this.showEventService.getShowEvents()
            .subscribe(function (showevents) { return _this.showevents = showevents; }, function (error) { return _this.errorMessage = error; });
    };
    ShowEventsComponent.prototype.ngOnInit = function () {
        this.getShowEvents();
        this.updateShowEventForm = this.formBuilder.group({
            name: ['', forms_1.Validators.required],
            location: ['', forms_1.Validators.required],
            date: ['', forms_1.Validators.required],
            closeDate: ['', forms_1.Validators.required],
            judge: ['', forms_1.Validators.required],
            shows: ['', forms_1.Validators.required],
        });
    };
    ShowEventsComponent.prototype.onSelect = function (showevent) {
        this.selectedShow = showevent;
    };
    ShowEventsComponent.prototype.deleteShow = function () {
        this.deleteMessage = 'Show delete!';
    };
    ShowEventsComponent = __decorate([
        core_1.Component({
            selector: 'showevents',
            templateUrl: './app/showevent/showevents.html',
            providers: [showevent_service_1.ShowEventService, forms_1.FormBuilder],
        }), 
        __metadata('design:paramtypes', [showevent_service_1.ShowEventService, forms_1.FormBuilder])
    ], ShowEventsComponent);
    return ShowEventsComponent;
}());
exports.ShowEventsComponent = ShowEventsComponent;
//# sourceMappingURL=showevents.component.js.map