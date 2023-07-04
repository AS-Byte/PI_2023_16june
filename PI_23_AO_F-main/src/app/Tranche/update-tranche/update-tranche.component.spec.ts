import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTrancheComponent } from './update-tranche.component';

describe('UpdateTrancheComponent', () => {
  let component: UpdateTrancheComponent;
  let fixture: ComponentFixture<UpdateTrancheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTrancheComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateTrancheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
