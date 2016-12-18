"use strict";
var Show;
(function (Show) {
    (function (ShowTypeEnum) {
        ShowTypeEnum[ShowTypeEnum["HALTERSHOW"] = 'HALTERSHOW'] = "HALTERSHOW";
        ShowTypeEnum[ShowTypeEnum["FLEECESHOW"] = 'FLEECESHOW'] = "FLEECESHOW";
        ShowTypeEnum[ShowTypeEnum["MALEPROGENYSHOW"] = 'MALE_PROGENY_SHOW'] = "MALEPROGENYSHOW";
        ShowTypeEnum[ShowTypeEnum["FEMALEPROGENYSHOW"] = 'FEMALE_PROGENY_SHOW'] = "FEMALEPROGENYSHOW";
    })(Show.ShowTypeEnum || (Show.ShowTypeEnum = {}));
    var ShowTypeEnum = Show.ShowTypeEnum;
})(Show = exports.Show || (exports.Show = {}));
