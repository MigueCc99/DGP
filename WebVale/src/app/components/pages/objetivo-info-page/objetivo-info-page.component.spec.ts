import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjetivoInfoPageComponent } from './objetivo-info-page.component';

describe('ObjetivoInfoPageComponent', () => {
  let component: ObjetivoInfoPageComponent;
  let fixture: ComponentFixture<ObjetivoInfoPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjetivoInfoPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjetivoInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
