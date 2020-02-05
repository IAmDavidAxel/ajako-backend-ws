import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverFindComponent } from './driver-find.component';

describe('DriverFindComponent', () => {
  let component: DriverFindComponent;
  let fixture: ComponentFixture<DriverFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
