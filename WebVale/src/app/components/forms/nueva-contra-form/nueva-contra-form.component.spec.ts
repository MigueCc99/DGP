import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevaContraFormComponent } from './nueva-contra-form.component';

describe('NuevaContraFormComponent', () => {
  let component: NuevaContraFormComponent;
  let fixture: ComponentFixture<NuevaContraFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevaContraFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevaContraFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
