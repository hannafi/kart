import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardHomeComponent} from './dashboard-home/dashboard-home.component';
import {DashboardChartComponent} from './dashboard-chart/dashboard-chart.component';
import {AuthGuard} from '../security/auth.guard';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardHomeComponent,
    canActivateChild: [AuthGuard],
    children: [
      {
        path: '',
        component: DashboardChartComponent
      },
      {
        path: '**',
        redirectTo: ''
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {
}
