import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDisponibilityComponent } from './add-disponibility.component';

describe('AddDisponibilityComponent', () => {
  let component: AddDisponibilityComponent;
  let fixture: ComponentFixture<AddDisponibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDisponibilityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddDisponibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
