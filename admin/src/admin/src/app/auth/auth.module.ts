import {NgModule} from '@angular/core';

import {AuthRoutingModule} from './auth-routing.module';
import {AppMaterialModule} from '../app-material.module';
import { AuthHomeComponent } from './auth-home/auth-home.component';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { AuthRecoverComponent } from './auth-recover/auth-recover.component';

@NgModule({
  declarations: [AuthHomeComponent, AuthLoginComponent, AuthRecoverComponent],
  imports: [
    AppMaterialModule,
    AuthRoutingModule
  ]
})
export class AuthModule { }
