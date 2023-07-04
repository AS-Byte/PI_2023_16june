import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllRdvsComponent } from './get-all-rdvs.component';

describe('GetAllRdvsComponent', () => {
  let component: GetAllRdvsComponent;
  let fixture: ComponentFixture<GetAllRdvsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllRdvsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllRdvsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
