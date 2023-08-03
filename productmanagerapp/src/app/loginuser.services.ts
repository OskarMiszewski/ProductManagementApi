import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { User } from './user'
import {Observable} from 'rxjs'

@Injectable({
  providedIn:'root'
})
export class LoginUserService
{
  constructor(private http: HttpClient)
  { }

  loginUser(user: User): Observable<any> {
    console.log(user)
    return this.http.post('http://localhost:8080/user/login', user);
  }

  // loginUser(user: User): Observable<any> {
  //   let headers = new HttpHeaders().set('Content-Type', 'application/json');
  //   return this.http.post('http://localhost8080/user/login', user, { headers });
  // }

  // public loginUser(user: User):Observable<object>
  // {
  //   console.log(user)
  //   return this.httpClient.post('http://localhost8080/user/login', user);
  // }
}
