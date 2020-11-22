import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SociosPageComponent } from './socios-page.component';

describe('SociosPageComponent', () => {
  let component: SociosPageComponent;
  let fixture: ComponentFixture<SociosPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SociosPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SociosPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
