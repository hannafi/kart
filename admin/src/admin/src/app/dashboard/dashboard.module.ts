import {NgModule} from '@angular/core';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {AppMaterialModule} from '../app-material.module';
import {DashboardHomeComponent} from './dashboard-home/dashboard-home.component';
import {DashboardChartComponent} from './dashboard-chart/dashboard-chart.component';

@NgModule({
  declarations: [DashboardHomeComponent, DashboardChartComponent],
  imports: [
    AppMaterialModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule {
}
