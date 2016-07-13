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
var showevent_service_1 = require('./showevent.service');
var ShowEventComponent = (function () {
    function ShowEventComponent(showEventService) {
        this.showEventService = showEventService;
        this.deleteMessage = '';
        this.updateMessage = '';
    }
    ShowEventComponent.prototype.getShowEvents = function () {
        var _this = this;
        this.showEventService.getShowEvents().then(function (showevents) { return _this.showevents = showevents; });
    };
    ShowEventComponent.prototype.ngOnInit = function () {
        this.getShowEvents();
    };
    ShowEventComponent.prototype.deleteShow = function () {
        this.deleteMessage = 'Show delete!';
    };
    ShowEventComponent.prototype.updateShow = function () {
        this.updateMessage = 'Show update!';
    };
    ShowEventComponent = __decorate([
        core_1.Component({
            selector: 'showevent-table',
            templateUrl: './app/show/showevent/showevent-table.html',
            providers: [showevent_service_1.ShowEventService]
        }), 
        __metadata('design:paramtypes', [showevent_service_1.ShowEventService])
    ], ShowEventComponent);
    return ShowEventComponent;
}());
exports.ShowEventComponent = ShowEventComponent;
//# sourceMappingURL=showevent.component.js.map