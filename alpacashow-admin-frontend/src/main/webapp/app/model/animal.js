"use strict";
var Animal = (function () {
    function Animal() {
    }
    return Animal;
}());
exports.Animal = Animal;
var Animal;
(function (Animal) {
    (function (BreedClassEnum) {
        BreedClassEnum[BreedClassEnum["HUACAYA"] = 'HUACAYA'] = "HUACAYA";
        BreedClassEnum[BreedClassEnum["SURI"] = 'SURI'] = "SURI";
        BreedClassEnum[BreedClassEnum["HUACAYAFLEECE"] = 'HUACAYAFLEECE'] = "HUACAYAFLEECE";
        BreedClassEnum[BreedClassEnum["SURIFLEECE"] = 'SURIFLEECE'] = "SURIFLEECE";
    })(Animal.BreedClassEnum || (Animal.BreedClassEnum = {}));
    var BreedClassEnum = Animal.BreedClassEnum;
    (function (SexClassEnum) {
        SexClassEnum[SexClassEnum["FEMALE"] = 'FEMALE'] = "FEMALE";
        SexClassEnum[SexClassEnum["MALE"] = 'MALE'] = "MALE";
    })(Animal.SexClassEnum || (Animal.SexClassEnum = {}));
    var SexClassEnum = Animal.SexClassEnum;
    (function (ColorClassEnum) {
        ColorClassEnum[ColorClassEnum["WHITE"] = 'WHITE'] = "WHITE";
        ColorClassEnum[ColorClassEnum["FAWN"] = 'FAWN'] = "FAWN";
        ColorClassEnum[ColorClassEnum["BROWN"] = 'BROWN'] = "BROWN";
        ColorClassEnum[ColorClassEnum["GREY"] = 'GREY'] = "GREY";
        ColorClassEnum[ColorClassEnum["BLACK"] = 'BLACK'] = "BLACK";
        ColorClassEnum[ColorClassEnum["FANCY"] = 'FANCY'] = "FANCY";
        ColorClassEnum[ColorClassEnum["BEIGE"] = 'BEIGE'] = "BEIGE";
    })(Animal.ColorClassEnum || (Animal.ColorClassEnum = {}));
    var ColorClassEnum = Animal.ColorClassEnum;
})(Animal = exports.Animal || (exports.Animal = {}));
//# sourceMappingURL=animal.js.map