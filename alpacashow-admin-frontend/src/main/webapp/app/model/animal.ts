export class Animal {
    name: string;
    breedClass: Animal.BreedClassEnum;
    sexClass: Animal.SexClassEnum;
    colorClass: Animal.ColorClassEnum;
    dateOfBirth: Date;
    microchip: string;
    registration: string;
    sire: string;
    dam: string;

}
export namespace Animal {
    export enum BreedClassEnum {
        HUACAYA = <any> 'HUACAYA',
        SURI = <any> 'SURI',
        HUACAYAFLEECE = <any> 'HUACAYAFLEECE',
        SURIFLEECE = <any> 'SURIFLEECE'
    }
    export enum SexClassEnum {
        FEMALE = <any> 'FEMALE',
        MALE = <any> 'MALE'
    }
    export enum ColorClassEnum {
        WHITE = <any> 'WHITE',
        FAWN = <any> 'FAWN',
        BROWN = <any> 'BROWN',
        GREY = <any> 'GREY',
        BLACK = <any> 'BLACK',
        FANCY = <any> 'FANCY',
        BEIGE = <any> 'BEIGE'
    }
}
