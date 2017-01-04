"use strict";
var router_1 = require('@angular/router');
var home_component_1 = require('./home/home.component');
var showevents_component_1 = require("./showevent/showevents.component");
var new_showevent_component_1 = require("./showevent/new-showevent.component");
var appRoutes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'showevents', component: showevents_component_1.ShowEventsComponent },
    { path: 'showevents/new-showevent', component: new_showevent_component_1.NewShowEventComponent }
];
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routing.js.map