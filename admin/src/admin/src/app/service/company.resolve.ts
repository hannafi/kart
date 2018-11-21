import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from '@angular/router';
import {EMPTY, Observable, of} from 'rxjs';
import {Company} from '../model/company';
import {AdminService} from './admin.service';
import {mergeMap, take} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CompanyResolve implements Resolve<Company> {

  constructor(private router: Router,
              private adminService: AdminService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Company> | Observable<never> {
    const id = route.paramMap.get('id');
    return this.adminService.getCompany(id).pipe(
      take(1),
      mergeMap(company => {
        if (company) {
          return of(company);
        } else { // id not found
          this.router.navigate(['/companies']);
          return EMPTY;
        }
      })
    );
  }

}
