import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOneContratComponent } from './get-one-contrat.component';

describe('GetOneContratComponent', () => {
  let component: GetOneContratComponent;
  let fixture: ComponentFixture<GetOneContratComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetOneContratComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetOneContratComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
