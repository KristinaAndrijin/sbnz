import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LearningMethodDialogComponent } from './learning-method-dialog.component';

describe('LearningMethodDialogComponent', () => {
  let component: LearningMethodDialogComponent;
  let fixture: ComponentFixture<LearningMethodDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LearningMethodDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LearningMethodDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
