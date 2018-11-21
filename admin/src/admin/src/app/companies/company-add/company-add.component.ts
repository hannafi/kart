import {Component, OnInit} from '@angular/core';
import {Company} from '../../model/company';
import {AdminService} from '../../service/admin.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-company-add',
  templateUrl: './company-add.component.html',
  styleUrls: ['./company-add.component.scss']
})
export class CompanyAddComponent implements OnInit {

  company: Company = new Company();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar,
              private adminService: AdminService) {
  }

  ngOnInit() {
  }

  create() {
    this.adminService.addCompany(this.company).subscribe(() => {
      this.router.navigate(['../'], {relativeTo: this.route});
      this.snackBar.open('Company ' + this.company.name + ' Added', 'Add Company Success', {duration: 3000});
    }, () => {
      this.snackBar.open('Error Adding Company ' + this.company.name, 'Add Company Error', {duration: 3000});
    });
  }

}
