import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {PagedCompanies} from '../model/paged-companies';
import {Company} from '../model/company';

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

  getCompany(id: string): Observable<Company> {
    return this.http.get<Company>(environment.adminEndpoint + '/companies/' + id);
  }

  addCompany(company: Company) {
    return this.http.post<Company>(environment.adminEndpoint + '/companies', company);
  }

  updateCompany(company: Company): Observable<Company> {
    return this.http.put<Company>(environment.adminEndpoint + '/companies/' + company.id, company);
  }
}
