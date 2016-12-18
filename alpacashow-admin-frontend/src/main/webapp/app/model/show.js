"use strict";
var Show = (function () {
    function Show() {
    }
    return Show;
}());
exports.Show = Show;
var Show;
(function (Show) {
    (function (ShowTypeEnum) {
        ShowTypeEnum[ShowTypeEnum["HALTERSHOW"] = 'Haltershow'] = "HALTERSHOW";
        ShowTypeEnum[ShowTypeEnum["FLEECESHOW"] = 'Fleeceshow'] = "FLEECESHOW";
        ShowTypeEnum[ShowTypeEnum["MALEPROGENYSHOW"] = 'Male progeny show'] = "MALEPROGENYSHOW";
        ShowTypeEnum[ShowTypeEnum["FEMALEPROGENYSHOW"] = 'Female progeny show'] = "FEMALEPROGENYSHOW";
    })(Show.ShowTypeEnum || (Show.ShowTypeEnum = {}));
    var ShowTypeEnum = Show.ShowTypeEnum;
})(Show = exports.Show || (exports.Show = {}));
//# sourceMappingURL=show.js.map