import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthRecoverComponent } from './auth-recover.component';

describe('AuthRecoverComponent', () => {
  let component: AuthRecoverComponent;
  let fixture: ComponentFixture<AuthRecoverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthRecoverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthRecoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
