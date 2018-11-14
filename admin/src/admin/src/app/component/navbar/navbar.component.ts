import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../service/auth.service';
import {Principal} from '../../model/principal';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  principal$: Observable<Principal>;

  constructor(private router: Router,
              private authService: AuthService) { }

  ngOnInit() {
    this.principal$ = this.authService.principal;
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
