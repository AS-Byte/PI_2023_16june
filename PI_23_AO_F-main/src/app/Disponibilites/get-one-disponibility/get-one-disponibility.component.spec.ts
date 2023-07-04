import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOneDisponibilityComponent } from './get-one-disponibility.component';

describe('GetOneDisponibilityComponent', () => {
  let component: GetOneDisponibilityComponent;
  let fixture: ComponentFixture<GetOneDisponibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetOneDisponibilityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetOneDisponibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
