import { TestBed } from '@angular/core/testing';

import { FacilitadoresService } from './facilitadores.service';

describe('FacilitadoresService', () => {
  let service: FacilitadoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FacilitadoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
