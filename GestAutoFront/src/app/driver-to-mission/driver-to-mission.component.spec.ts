import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverToMissionComponent } from './driver-to-mission.component';

describe('DriverToMissionComponent', () => {
  let component: DriverToMissionComponent;
  let fixture: ComponentFixture<DriverToMissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverToMissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverToMissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
