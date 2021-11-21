import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})

export class ResetService {
    constructor(protected http:HttpClient){}

    postReset( data: any):Observable<any>{
        return this.http.post( 'http://localhost:8080/reset', data );
    }
}
