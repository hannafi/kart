import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-auth-recover',
  templateUrl: './auth-recover.component.html',
  styleUrls: ['./auth-recover.component.scss']
})
export class AuthRecoverComponent implements OnInit {

  email: string;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private snackBar: MatSnackBar,
              private authService: AuthService) { }

  ngOnInit() {
  }

  recover() {
    this.authService.recover(this.email).subscribe(() => {
      this.snackBar.open('A password recovery link has been sent to you.', 'Reset Password', {duration: 3000});
    }, error => {
      this.snackBar.open('Can\'t find that email, sorry.', 'Reset Password Error', {duration: 3000});
    });
  }
}
