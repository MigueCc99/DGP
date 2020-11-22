import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocioActividadPageComponent } from './socio-actividad-page.component';

describe('SocioActividadPageComponent', () => {
  let component: SocioActividadPageComponent;
  let fixture: ComponentFixture<SocioActividadPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SocioActividadPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SocioActividadPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
