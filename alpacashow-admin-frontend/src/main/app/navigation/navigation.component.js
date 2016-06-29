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
var router_1 = require('@angular/router');
var showevent_component_1 = require("../showevent/showevent.component");
var home_component_1 = require('../home/home.component');
var NavigationComponent = (function () {
    function NavigationComponent() {
    }
    NavigationComponent = __decorate([
        core_1.Component({
            selector: 'app-with-navigation',
            template: "\n    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n        <div class=\"container-fluid\">\n            <div class=\"navbar-header\">\n                <a class=\"navbar-brand\" [routerLink]=\"['Home']\">Home</a>\n                <a class=\"navbar-brand\" [routerLink]=\"['Show']\">Show</a>\n            </div>\n            <div class=\"collapse navbar-collapse\">\n                <ul class=\"nav navbar-nav navbar-right\">\n                    <li><a href=\"https://github.com/anniekvandijk/alpacashow-admin-app\">Github</a></li>\n                </ul>\n            </div>\n        </div>\n    </div>\n    <div class=\"container-fluid\">\n        <div class=\"content\">\n            <router-outlet></router-outlet>\n        </div>\n    </div>\n    ",
            directives: router_1.ROUTER_DIRECTIVES
        }), 
        __metadata('design:paramtypes', [])
    ], NavigationComponent);
    return NavigationComponent;
}());
exports.NavigationComponent = NavigationComponent;
exports.routes = [
    { path: '', component: home_component_1.HomeComponent },
    { path: 'Home', component: home_component_1.HomeComponent },
    { path: 'Show', component: showevent_component_1.ShowEventComponent },
];
exports.APP_ROUTER_PROVIDERS = [
    router_1.provideRouter(exports.routes)
];
//# sourceMappingURL=navigation.component.js.map