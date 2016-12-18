export interface Show {
    showType?: Show.ShowTypeEnum;

}
export namespace Show {
    export enum ShowTypeEnum {
        HALTERSHOW = <any> 'HALTERSHOW',
        FLEECESHOW = <any> 'FLEECESHOW',
        MALEPROGENYSHOW = <any> 'MALE_PROGENY_SHOW',
        FEMALEPROGENYSHOW = <any> 'FEMALE_PROGENY_SHOW'
    }
}
