import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjetivosPageComponent } from './objetivos-page.component';

describe('ObjetivosPageComponent', () => {
  let component: ObjetivosPageComponent;
  let fixture: ComponentFixture<ObjetivosPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjetivosPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjetivosPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
