import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjetivoFormComponent } from './objetivo-form.component';

describe('ObjetivoFormComponent', () => {
  let component: ObjetivoFormComponent;
  let fixture: ComponentFixture<ObjetivoFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjetivoFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjetivoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
