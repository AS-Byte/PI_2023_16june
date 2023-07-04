import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOneRdvComponent } from './get-one-rdv.component';

describe('GetOneRdvComponent', () => {
  let component: GetOneRdvComponent;
  let fixture: ComponentFixture<GetOneRdvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetOneRdvComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetOneRdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
