import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './auth-login.component.html',
  styleUrls: ['./auth-login.component.scss']
})
export class AuthLoginComponent implements OnInit {

  username: string;
  password: string;
  returnUrl: string;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private snackBar: MatSnackBar,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['redirectUrl'] || '/';
  }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(() => {
      this.authService.reloadPrincipal();
      this.router.navigate([this.returnUrl]);
    }, () => {
      this.snackBar.open('Please Verify Your Login/Password', 'Login Error', {duration: 3000});
    });
  }

}
