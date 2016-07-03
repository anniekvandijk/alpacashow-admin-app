export class NewShowEvent {
    
    constructor(
        public name: string,
        public location: string,
        public date: string,
        public closedate: string,
        public judge: string,
        public haltershow: boolean,
        public fleeceshow: boolean,
        public maleprogenyshow: boolean,
        public femaleprogenyshow: boolean
    ) {  }
}