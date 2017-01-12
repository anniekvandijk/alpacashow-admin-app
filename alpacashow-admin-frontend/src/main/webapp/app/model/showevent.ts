import {Participant} from "./participant";

export class ShowEvent {
    name: string;
    date: string;
    closeDate: string;
    location: string;
    judge: string;
    showType: ShowEvent.ShowTypeEnum;
    participants: Participant[];
}

export namespace ShowEvent {
    export enum ShowTypeEnum {
        HALTERSHOW = <any> 'Haltershow',
        FLEECESHOW = <any> 'Fleeceshow',
        MALE_PROGENY_SHOW = <any> 'Male progeny show',
        FEMALE_PROGENY_SHOW = <any> 'Female progeny show'
    }
}
