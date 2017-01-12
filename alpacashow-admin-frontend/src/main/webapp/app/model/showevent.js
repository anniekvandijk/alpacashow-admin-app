"use strict";
var ShowEvent = (function () {
    function ShowEvent() {
    }
    return ShowEvent;
}());
exports.ShowEvent = ShowEvent;
var ShowEvent;
(function (ShowEvent) {
    (function (ShowTypeEnum) {
        ShowTypeEnum[ShowTypeEnum["HALTERSHOW"] = 'Haltershow'] = "HALTERSHOW";
        ShowTypeEnum[ShowTypeEnum["FLEECESHOW"] = 'Fleeceshow'] = "FLEECESHOW";
        ShowTypeEnum[ShowTypeEnum["MALE_PROGENY_SHOW"] = 'Male progeny show'] = "MALE_PROGENY_SHOW";
        ShowTypeEnum[ShowTypeEnum["FEMALE_PROGENY_SHOW"] = 'Female progeny show'] = "FEMALE_PROGENY_SHOW";
    })(ShowEvent.ShowTypeEnum || (ShowEvent.ShowTypeEnum = {}));
    var ShowTypeEnum = ShowEvent.ShowTypeEnum;
})(ShowEvent = exports.ShowEvent || (exports.ShowEvent = {}));
//# sourceMappingURL=showevent.js.map