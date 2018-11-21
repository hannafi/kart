import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {Company} from '../../model/company';
import {AdminService} from '../../service/admin.service';
import {merge} from 'rxjs';
import {map, startWith, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.scss']
})
export class CompanyListComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['name', 'vat', 'phone', 'email', 'creationDate', 'enabled'];
  companiesDataSource: MatTableDataSource<Company> = new MatTableDataSource<Company>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  pageSize = 5;

  constructor(private adminService: AdminService) {
  }

  ngOnInit() {
    this.paginator.pageSize = this.pageSize;
  }

  ngAfterViewInit() {

    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.companiesDataSource.data = [];
          return this.adminService.getCompanies(this.paginator.pageIndex,
            this.paginator.pageSize, this.sort.active + ',' + this.sort.direction);
        }),
        map(page => {
          this.paginator.length = page.totalElements;
          return page.content;
        }),
      ).subscribe(companies => this.companiesDataSource.data = companies);
  }

}
