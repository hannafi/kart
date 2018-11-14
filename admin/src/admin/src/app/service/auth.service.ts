import {Injectable} from '@angular/core';

import {environment} from '../../environments/environment';
import {Principal} from '../model/principal';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {Token} from '../model/token';
import {StorageService} from './storage.service';
import {map} from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class AuthService {

  private principalSubject: BehaviorSubject<Principal>;
  public principal: Observable<Principal>;

  constructor(private http: HttpClient,
              protected storageService: StorageService) {
    this.principalSubject = new BehaviorSubject<Principal>(null);
    this.principal = this.principalSubject.asObservable();
  }

  public reloadPrincipal(): void {
    this.http.get<Principal>(environment.adminEndpoint + '/principal').subscribe(
      user => {
        this.next(user);
      });
  }

  public login(username: string, password: string) : Observable<Token> {
    const headers = new HttpHeaders()
      .set('Authorization', 'Basic ' + btoa(environment.clientId + ':' + environment.clientSecret));

    const params = new HttpParams()
      .set('grant_type', 'password')
      .set('username', username)
      .set('password', password);

    return this.http.post<Token>(environment.tokenEndpoint, params, {headers: headers})
      .pipe(
        map(token => {
          this.storageService.storeToken(token);
          return token;
        })
      );
  }

  public logout() {
    this.storageService.removeToken();
    this.next(null);
  }

  public next(user: Principal): void {
    this.principalSubject.next(user);
  }

  hasToken() : boolean {
    return !!this.storageService.getToken();
  }

  getToken() : Token {
    return this.storageService.getToken();
  }
}
