export class Show {
    showType: Show.ShowTypeEnum;

}
export namespace Show {
    export enum ShowTypeEnum {
        HALTERSHOW = <any> 'Haltershow',
        FLEECESHOW = <any> 'Fleeceshow',
        MALEPROGENYSHOW = <any> 'Male progeny show',
        FEMALEPROGENYSHOW = <any> 'Female progeny show'
    }
}
