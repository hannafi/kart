import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthLoginComponent} from './auth-login/auth-login.component';
import {AuthRecoverComponent} from './auth-recover/auth-recover.component';
import {AuthHomeComponent} from './auth-home/auth-home.component';

const routes: Routes = [
  {
    path: 'auth',
    component: AuthHomeComponent,
    children: [
      {
        path: 'login',
        component: AuthLoginComponent
      },
      {
        path: 'recover',
        component: AuthRecoverComponent
      },
      {
        path: '**',
        redirectTo: 'login'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {
}
