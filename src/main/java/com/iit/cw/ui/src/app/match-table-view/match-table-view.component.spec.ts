import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchTableViewComponent } from './match-table-view.component';

describe('MatchTableViewComponent', () => {
  let component: MatchTableViewComponent;
  let fixture: ComponentFixture<MatchTableViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatchTableViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatchTableViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
