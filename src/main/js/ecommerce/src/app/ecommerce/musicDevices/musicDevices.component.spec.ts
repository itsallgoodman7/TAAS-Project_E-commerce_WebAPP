import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicDevicesComponent } from './musicDevices.component';

describe('MusicDevicesComponent', () => {
  let component: MusicDevicesComponent;
  let fixture: ComponentFixture<MusicDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
