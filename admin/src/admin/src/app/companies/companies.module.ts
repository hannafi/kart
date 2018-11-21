import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompaniesRoutingModule } from './companies-routing.module';
import { CompanyListComponent } from './company-list/company-list.component';
import { CompanyDetailComponent } from './company-detail/company-detail.component';
import { CompanyHomeComponent } from './company-home/company-home.component';
import {AppMaterialModule} from '../app-material.module';
import { CompanyAddComponent } from './company-add/company-add.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [CompanyListComponent, CompanyDetailComponent, CompanyHomeComponent, CompanyAddComponent],
  imports: [
    CommonModule,
    AppMaterialModule,
    FormsModule,
    CompaniesRoutingModule
  ]
})
export class CompaniesModule { }
