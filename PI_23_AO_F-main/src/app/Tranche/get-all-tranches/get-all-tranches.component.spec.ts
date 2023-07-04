import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTranchesComponent } from './get-all-tranches.component';

describe('GetAllTranchesComponent', () => {
  let component: GetAllTranchesComponent;
  let fixture: ComponentFixture<GetAllTranchesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllTranchesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllTranchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
