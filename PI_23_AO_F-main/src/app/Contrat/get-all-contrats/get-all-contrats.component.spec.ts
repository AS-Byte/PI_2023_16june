import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllContratsComponent } from './get-all-contrats.component';

describe('GetAllContratsComponent', () => {
  let component: GetAllContratsComponent;
  let fixture: ComponentFixture<GetAllContratsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllContratsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllContratsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
