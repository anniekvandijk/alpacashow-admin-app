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
        HUACAYA = <any> 'Huacaya',
        SURI = <any> 'Suri',
        HUACAYAFLEECE = <any> 'Huacayafleece',
        SURIFLEECE = <any> 'Surifleece'
    }
    export enum SexClassEnum {
        FEMALE = <any> 'Female',
        MALE = <any> 'Male'
    }
    export enum ColorClassEnum {
        WHITE = <any> 'White',
        FAWN = <any> 'Fawn',
        BROWN = <any> 'Brown',
        GREY = <any> 'Grey',
        BLACK = <any> 'Black',
        FANCY = <any> 'Fancy',
        BEIGE = <any> 'Beige'
    }
}
