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
    { showType: 'Haltershow' },
    { showType: 'Fleeceshow' },
    { showType: 'Male progeny show' },
    { showType: 'Female progeny show' }
];
var NewShowEventComponent = (function () {
    function NewShowEventComponent(formBuilder) {
        this.formBuilder = formBuilder;
        this.showtypes = SHOWTYPES;
        this.submitted = false;
        this.showtypeSelected = false;
        this.active = true;
        this.shows = [];
    }
    // TODO change button collor when selected. After another click set default and remove showtype.
    NewShowEventComponent.prototype.select = function (showtype) {
        this.shows.push(showtype);
    };
    NewShowEventComponent.prototype.remove = function (showtype) {
        this.shows.splice(this.shows.indexOf(showtype), 1);
    };
    NewShowEventComponent.prototype.ngOnInit = function () {
        this.newShowEventForm = this.formBuilder.group({
            name: ['', forms_1.Validators.required],
            location: ['', forms_1.Validators.required],
            date: ['', forms_1.Validators.required],
            closeDate: ['', forms_1.Validators.required],
            judge: ['', forms_1.Validators.required],
            shows: ['', forms_1.Validators.required],
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
        }), 
        __metadata('design:paramtypes', [forms_1.FormBuilder])
    ], NewShowEventComponent);
    return NewShowEventComponent;
}());
exports.NewShowEventComponent = NewShowEventComponent;
//# sourceMappingURL=new-showevent.component.js.map