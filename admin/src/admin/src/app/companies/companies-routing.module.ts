import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CompanyListComponent} from './company-list/company-list.component';
import {CompanyHomeComponent} from './company-home/company-home.component';
import {CompanyDetailComponent} from './company-detail/company-detail.component';
import {CompanyAddComponent} from './company-add/company-add.component';
import {AuthGuard} from '../security/auth.guard';
import {CompanyResolve} from '../service/company.resolve';

const routes: Routes = [
  {
    path: 'companies',
    component: CompanyHomeComponent,
    canActivate:[AuthGuard],
    children: [
      {
        path: '',
        component: CompanyListComponent
      },
      {
        path: 'add',
        component: CompanyAddComponent
      },
      {
        path: ':id',
        component: CompanyDetailComponent,
        resolve: {
          company: CompanyResolve
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompaniesRoutingModule {
}
