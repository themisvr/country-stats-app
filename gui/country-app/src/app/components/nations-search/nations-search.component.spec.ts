import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationsSearchComponent } from './nations-search.component';

describe('NationsSearchComponent', () => {
  let component: NationsSearchComponent;
  let fixture: ComponentFixture<NationsSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NationsSearchComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NationsSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
