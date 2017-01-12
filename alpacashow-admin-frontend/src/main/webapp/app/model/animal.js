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
        BreedClassEnum[BreedClassEnum["HUACAYA"] = 'Huacaya'] = "HUACAYA";
        BreedClassEnum[BreedClassEnum["SURI"] = 'Suri'] = "SURI";
        BreedClassEnum[BreedClassEnum["HUACAYAFLEECE"] = 'Huacayafleece'] = "HUACAYAFLEECE";
        BreedClassEnum[BreedClassEnum["SURIFLEECE"] = 'Surifleece'] = "SURIFLEECE";
    })(Animal.BreedClassEnum || (Animal.BreedClassEnum = {}));
    var BreedClassEnum = Animal.BreedClassEnum;
    (function (SexClassEnum) {
        SexClassEnum[SexClassEnum["FEMALE"] = 'Female'] = "FEMALE";
        SexClassEnum[SexClassEnum["MALE"] = 'Male'] = "MALE";
    })(Animal.SexClassEnum || (Animal.SexClassEnum = {}));
    var SexClassEnum = Animal.SexClassEnum;
    (function (ColorClassEnum) {
        ColorClassEnum[ColorClassEnum["WHITE"] = 'White'] = "WHITE";
        ColorClassEnum[ColorClassEnum["FAWN"] = 'Fawn'] = "FAWN";
        ColorClassEnum[ColorClassEnum["BROWN"] = 'Brown'] = "BROWN";
        ColorClassEnum[ColorClassEnum["GREY"] = 'Grey'] = "GREY";
        ColorClassEnum[ColorClassEnum["BLACK"] = 'Black'] = "BLACK";
        ColorClassEnum[ColorClassEnum["FANCY"] = 'Fancy'] = "FANCY";
        ColorClassEnum[ColorClassEnum["BEIGE"] = 'Beige'] = "BEIGE";
    })(Animal.ColorClassEnum || (Animal.ColorClassEnum = {}));
    var ColorClassEnum = Animal.ColorClassEnum;
})(Animal = exports.Animal || (exports.Animal = {}));
//# sourceMappingURL=animal.js.map