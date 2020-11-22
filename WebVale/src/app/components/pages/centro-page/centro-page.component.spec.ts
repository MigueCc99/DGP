import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentroPageComponent } from './centro-page.component';

describe('CentroPageComponent', () => {
  let component: CentroPageComponent;
  let fixture: ComponentFixture<CentroPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CentroPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CentroPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
