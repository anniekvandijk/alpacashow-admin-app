"use strict";
var platform_browser_dynamic_1 = require('@angular/platform-browser-dynamic');
var app_component_1 = require('./app.component');
var forms_1 = require('@angular/forms');
var navigation_component_1 = require('./navigation/navigation.component');
platform_browser_dynamic_1.bootstrap(app_component_1.AppComponent, [
    navigation_component_1.APP_ROUTER_PROVIDERS, forms_1.disableDeprecatedForms(), forms_1.provideForms()
])
    .catch(function (err) { return console.error(err); });
//# sourceMappingURL=app.js.map