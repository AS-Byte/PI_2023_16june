import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerSingleComponent } from './owner-single.component';

describe('OwnerSingleComponent', () => {
  let component: OwnerSingleComponent;
  let fixture: ComponentFixture<OwnerSingleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerSingleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnerSingleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
