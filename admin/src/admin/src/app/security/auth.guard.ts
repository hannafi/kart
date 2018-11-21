import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivateChild, CanLoad, Route, Router, RouterStateSnapshot, UrlSegment} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from '../service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanLoad, CanActivateChild {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  canLoad(route: Route, segments: UrlSegment[]): Observable<boolean> | Promise<boolean> | boolean {
    return this.canActivate(route.path);
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.canActivate(state.url);
  }

  private canActivate(redirectUrl: string): boolean {
    if (this.authService.hasToken()) {
      return true;
    }
    // not logged in so redirect to login page
    this.router.navigate(['/auth'], {queryParams: {redirectUrl: redirectUrl}});
    return false;
  }
}
