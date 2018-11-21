import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Company} from '../../model/company';
import {AdminService} from '../../service/admin.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-company-detail',
  templateUrl: './company-detail.component.html',
  styleUrls: ['./company-detail.component.scss']
})
export class CompanyDetailComponent implements OnInit {

  private original: Company;
  company: Company;

  constructor(private route: ActivatedRoute,
              private snackBar: MatSnackBar,
              private adminService: AdminService) {
  }

  ngOnInit() {
    this.route.data.subscribe((data: { company: Company }) => {
      this.original = { ...data.company } ;
      this.company = { ...data.company };
    });
  }

  update() {
    this.adminService.updateCompany(this.company).subscribe(company => {
      this.original = { ...company } ;
      this.company = { ...company };
      this.snackBar.open('Company ' + this.company.name + ' Updated', 'Update Success', {duration: 3000});
    },() => {
      this.snackBar.open('Error Updating Company ' + this.company.name, 'Update Error', {duration: 3000});
    });
  }

  cancel() {
    this.company = { ...this.original };
  }

}
