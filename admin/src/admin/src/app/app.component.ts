import {Component, OnInit} from '@angular/core';
import {AuthService} from './service/auth.service';
import {Observable} from 'rxjs';
import {Principal} from './model/principal';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  principal$: Observable<Principal>;

  constructor(private router: Router,
              private authService: AuthService) {
    this.principal$ = this.authService.principal;
  }

  ngOnInit() {
    if (this.authService.hasToken()) {
      this.authService.reloadPrincipal();
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

}
