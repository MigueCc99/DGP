import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitadorFormComponent } from './facilitador-form.component';

describe('FacilitadorFormComponent', () => {
  let component: FacilitadorFormComponent;
  let fixture: ComponentFixture<FacilitadorFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacilitadorFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilitadorFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
