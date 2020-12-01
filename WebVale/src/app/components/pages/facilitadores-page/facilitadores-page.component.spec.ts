import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilitadoresPageComponent } from './facilitadores-page.component';

describe('FacilitadoresPageComponent', () => {
  let component: FacilitadoresPageComponent;
  let fixture: ComponentFixture<FacilitadoresPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacilitadoresPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilitadoresPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
