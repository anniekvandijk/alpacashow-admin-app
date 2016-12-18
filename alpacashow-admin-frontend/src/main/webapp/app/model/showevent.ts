import {Show} from "./show";
import {Participant} from "./participant";

export class ShowEvent {
    name: string;
    date: string;
    closeDate: string;
    location: string;
    judge: string;
    shows: Show[];
    participants: Participant[];
}
