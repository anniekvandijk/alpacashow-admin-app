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
var ShowType = (function () {
    function ShowType() {
    }
    return ShowType;
}());
exports.ShowType = ShowType;
var SHOWTYPES = [
    { value: false, name: 'haltershow', label: 'Haltershow' },
    { value: false, name: 'fleeceshow', label: 'Fleeceshow' },
    { value: false, name: 'maleprogenyshow', label: 'Male progeny show' },
    { value: false, name: 'femaleprogenyshow', label: 'Female progeny show' }
];
var NewShowEventComponent = (function () {
    function NewShowEventComponent(formBuilder) {
        this.formBuilder = formBuilder;
        this.showtypes = SHOWTYPES;
        this.submitted = false;
        this.active = true;
    }
    NewShowEventComponent.prototype.ngOnInit = function () {
        this.showEventForm = this.formBuilder.group({
            name: ['', forms_1.Validators.required],
            location: ['', forms_1.Validators.required],
            date: ['', forms_1.Validators.required],
            closedate: ['', forms_1.Validators.required],
            judge: ['', forms_1.Validators.required],
            haltershow: ['',],
            fleeceshow: ['',],
            maleprogenyshow: ['',],
            femaleprogenyshow: ['',],
        });
    };
    NewShowEventComponent.prototype.onSubmit = function (form) {
        this.submitted = true;
        //    this.active = false;
        //   setTimeout(() => this.active = true, 0);
        console.log('you submitted value:', form);
        console.log('json output: ', JSON.stringify(form));
        // json sent to backend
    };
    NewShowEventComponent = __decorate([
        core_1.Component({
            selector: 'new-showevent',
            templateUrl: './app/showevent/new-showevent.html',
            providers: [forms_1.FormBuilder],
            directives: [forms_1.FORM_DIRECTIVES, forms_1.REACTIVE_FORM_DIRECTIVES],
        }), 
        __metadata('design:paramtypes', [forms_1.FormBuilder])
    ], NewShowEventComponent);
    return NewShowEventComponent;
}());
exports.NewShowEventComponent = NewShowEventComponent;
//# sourceMappingURL=new-showevent.component.js.map