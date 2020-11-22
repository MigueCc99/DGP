import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocioInfoPageComponent } from './socio-info-page.component';

describe('SocioInfoPageComponent', () => {
  let component: SocioInfoPageComponent;
  let fixture: ComponentFixture<SocioInfoPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SocioInfoPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SocioInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
