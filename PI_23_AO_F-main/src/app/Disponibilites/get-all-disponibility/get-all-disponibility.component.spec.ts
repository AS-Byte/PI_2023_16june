import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllDisponibilityComponent } from './get-all-disponibility.component';

describe('GetAllDisponibilityComponent', () => {
  let component: GetAllDisponibilityComponent;
  let fixture: ComponentFixture<GetAllDisponibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllDisponibilityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllDisponibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
