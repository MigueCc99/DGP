import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SociosRecuperaContraPageComponent } from './socios-recupera-contra-page.component';

describe('SociosRecuperaContraPageComponent', () => {
  let component: SociosRecuperaContraPageComponent;
  let fixture: ComponentFixture<SociosRecuperaContraPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SociosRecuperaContraPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SociosRecuperaContraPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
