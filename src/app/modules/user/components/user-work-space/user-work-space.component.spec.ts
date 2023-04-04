import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserWorkSpaceComponent } from './user-work-space.component';

describe('UserWorkSpaceComponent', () => {
  let component: UserWorkSpaceComponent;
  let fixture: ComponentFixture<UserWorkSpaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserWorkSpaceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserWorkSpaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
