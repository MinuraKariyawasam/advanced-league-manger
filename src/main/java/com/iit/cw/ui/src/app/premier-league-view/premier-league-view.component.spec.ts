import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PremierLeagueViewComponent } from './premier-league-view.component';

describe('PremierLeagueViewComponent', () => {
  let component: PremierLeagueViewComponent;
  let fixture: ComponentFixture<PremierLeagueViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PremierLeagueViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PremierLeagueViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
