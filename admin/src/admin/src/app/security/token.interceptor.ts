import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Token} from '../model/token';
import {AuthService} from '../service/auth.service';
import {Router} from '@angular/router';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (req.url.indexOf('/oauth/token') >= 0) {
      return next.handle(req);
    }

    return next.handle(this.addToken(req, this.authService.getToken()))
      .pipe(
        catchError(err => {
          if (err.status === 401) {
            this.authService.logout();
            this.router.navigate(['/login']);
            return throwError(err);
          }
          return next.handle(req);
        }));
  }

  private addToken(request: HttpRequest<any>, token: Token): HttpRequest<any> {
    if (token) {
      return request.clone({setHeaders: {Authorization: `Bearer ${token.access_token}`}});
    }
    return request;
  }

}
