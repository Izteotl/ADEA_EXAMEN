import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
    providedIn: 'root'
})

export class LoginService {
    constructor(protected http:HttpClient){}

    postLogin( userData: any):Observable<any>{
        return this.http.post( 'http://localhost:8080/authenticate', userData );
    }
}
