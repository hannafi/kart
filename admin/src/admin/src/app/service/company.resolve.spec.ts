import {inject, TestBed} from '@angular/core/testing';

import {CompanyResolve} from './company.resolve';

describe('CompanyResolve', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompanyResolve]
    });
  });

  it('should be created', inject([CompanyResolve], (guard: CompanyResolve) => {
    expect(guard).toBeTruthy();
  }));
});
