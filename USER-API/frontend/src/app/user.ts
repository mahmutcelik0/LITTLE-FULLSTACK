import { RouterLinkWithHref } from "@angular/router";

export class User
{
    name:string;
    email:string;
    experience:number;
    domain:string;

    constructor() {
        this.name = "";
        this.email = "";
        this.experience = 0;
        this.domain = "";
    }
} 