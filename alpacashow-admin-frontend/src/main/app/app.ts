import { bootstrap } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app.component';
import { disableDeprecatedForms, provideForms } from '@angular/forms';
import { APP_ROUTER_PROVIDERS } from './navigation/navigation.component';


bootstrap(AppComponent, [
    APP_ROUTER_PROVIDERS, disableDeprecatedForms(), provideForms()
])
    .catch(err => console.error(err));
