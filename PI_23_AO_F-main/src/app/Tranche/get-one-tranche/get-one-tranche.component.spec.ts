import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOneTrancheComponent } from './get-one-tranche.component';

describe('GetOneTrancheComponent', () => {
  let component: GetOneTrancheComponent;
  let fixture: ComponentFixture<GetOneTrancheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetOneTrancheComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetOneTrancheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
