import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTrancheComponent } from './add-tranche.component';

describe('AddTrancheComponent', () => {
  let component: AddTrancheComponent;
  let fixture: ComponentFixture<AddTrancheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTrancheComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddTrancheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
