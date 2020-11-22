import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadInfoPageComponent } from './actividad-info-page.component';

describe('ActividadInfoPageComponent', () => {
  let component: ActividadInfoPageComponent;
  let fixture: ComponentFixture<ActividadInfoPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActividadInfoPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
