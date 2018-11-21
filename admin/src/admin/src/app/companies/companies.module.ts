import {NgModule} from '@angular/core';

import {CompaniesRoutingModule} from './companies-routing.module';
import {CompanyListComponent} from './company-list/company-list.component';
import {CompanyDetailComponent} from './company-detail/company-detail.component';
import {CompanyHomeComponent} from './company-home/company-home.component';
import {AppMaterialModule} from '../app-material.module';
import {CompanyAddComponent} from './company-add/company-add.component';

@NgModule({
  declarations: [CompanyListComponent, CompanyDetailComponent, CompanyHomeComponent, CompanyAddComponent],
  imports: [
    AppMaterialModule,
    CompaniesRoutingModule
  ]
})
export class CompaniesModule { }
