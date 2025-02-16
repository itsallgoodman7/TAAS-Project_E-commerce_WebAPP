import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicDevicedescriptionComponent } from './musicDevicedescription.component';

describe('MusicDevicedescriptionComponent', () => {
  let component: MusicDevicedescriptionComponent;
  let fixture: ComponentFixture<MusicDevicedescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MusicDevicedescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicDevicedescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
