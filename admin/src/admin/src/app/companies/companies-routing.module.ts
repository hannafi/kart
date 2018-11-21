import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CompanyListComponent} from './company-list/company-list.component';
import {CompanyHomeComponent} from './company-home/company-home.component';
import {CompanyDetailComponent} from './company-detail/company-detail.component';
import {CompanyAddComponent} from './company-add/company-add.component';
import {CompanyResolve} from '../service/company.resolve';
import {AuthGuard} from '../security/auth.guard';

const routes: Routes = [
  {
    path: 'companies',
    component: CompanyHomeComponent,
    canActivateChild: [AuthGuard],
    children: [
      {
        path: 'list',
        component: CompanyListComponent
      },
      {
        path: 'add',
        component: CompanyAddComponent
      },
      {
        path: 'edit/:id',
        component: CompanyDetailComponent,
        resolve: {
          company: CompanyResolve
        }
      },
      {
        path: '**',
        redirectTo: 'list'
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
