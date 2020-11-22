import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActividadesPageComponent } from './actividades-page.component';

describe('ActividadesPageComponent', () => {
  let component: ActividadesPageComponent;
  let fixture: ComponentFixture<ActividadesPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActividadesPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActividadesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
