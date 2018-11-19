import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {PagedCompanies} from '../model/paged-companies';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) {
  }

  getCompanies(page: number, size: number, sort: string): Observable<PagedCompanies> {

    const params: HttpParams = new HttpParams()
      .set('page', String(page))
      .set('size', String(size))
      .set('sort', sort);

    return this.http.get<PagedCompanies>(environment.adminEndpoint + '/companies', {params: params});
  }

}
