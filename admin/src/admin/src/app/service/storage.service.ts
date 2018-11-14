import {Injectable} from '@angular/core';
import {Token} from '../model/token';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() {
  }

  public storeToken(token: Token): void {
    localStorage.setItem(environment.tokenKey, JSON.stringify(token));
  }

  getToken(): Token {
    try {
      return JSON.parse(localStorage.getItem(environment.tokenKey));
    } catch (e) {
      return null;
    }
  }

  removeToken() {
    localStorage.removeItem(environment.tokenKey);
  }
}
