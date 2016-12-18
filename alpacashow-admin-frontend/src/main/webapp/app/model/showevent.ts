import * as models from './models';

export interface ShowEvent {
    name?: string;
    date?: string;
    closeDate?: string;
    location?: string;
    judge?: string;
    participants?: Array<models.Participant>;
    show?: Array<models.Show>;
}
