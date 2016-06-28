import { bootstrap } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app.component';
import { APP_ROUTER_PROVIDERS } from './navigation/navigation.component';

bootstrap(AppComponent, [
    APP_ROUTER_PROVIDERS
])
    .catch(err => console.error(err));