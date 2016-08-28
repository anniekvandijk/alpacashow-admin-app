"use strict";
var router_1 = require('@angular/router');
var home_component_1 = require('./home/home.component');
var showevents_component_1 = require("./showevent/showevents.component");
var appRoutes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: home_component_1.HomeComponent
    },
    {
        path: 'showevent',
        component: showevents_component_1.ShowEventsComponent
    }
];
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routing.js.map