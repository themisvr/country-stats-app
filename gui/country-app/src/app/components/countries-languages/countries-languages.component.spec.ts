import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountriesLanguagesComponent } from './countries-languages.component';

describe('CountriesLanguagesComponent', () => {
  let component: CountriesLanguagesComponent;
  let fixture: ComponentFixture<CountriesLanguagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountriesLanguagesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CountriesLanguagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
