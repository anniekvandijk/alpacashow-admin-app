"use strict";
var router_1 = require('@angular/router');
var home_component_1 = require("../home/home.component");
var showevent_component_1 = require("../showevent/showevent.component");
exports.routes = [
    { path: '', redirectTo: 'home' },
    { path: 'Home', component: home_component_1.HomeComponent },
    { path: 'Show', component: showevent_component_1.ShowEventComponent },
];
var NavigationComponent = (function () {
    function NavigationComponent() {
    }
    return NavigationComponent;
}());
exports.NavigationComponent = NavigationComponent;
exports.APP_ROUTER_PROVIDERS = [
    router_1.provideRouter(exports.routes)
];
//# sourceMappingURL=navigation.component.js.map