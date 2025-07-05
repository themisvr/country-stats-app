import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { CountryLanguage, CountryLanguagesResponse } from '../../models/language.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-countries-languages',
  templateUrl: './countries-languages.component.html',
  standalone: true,
  imports: [CommonModule],
  styleUrls: ['./countries-languages.component.css']
})
export class CountriesLanguagesComponent implements OnInit {
  noData: boolean = false;
  countryCode: string = '';
  languages: CountryLanguage[] = [];
  errorMessage: string = '';
  countryName: string | undefined;

  constructor(
    private route: ActivatedRoute,
    private countryService: CountryService
  ) {}

  ngOnInit(): void {
    this.countryName = this.route.snapshot.queryParamMap.get('countryName') || 'Unknown Country';
    this.countryCode = this.route.snapshot.paramMap.get('code') || '';

    if (this.countryCode) {
      this.countryService.getLanguages(this.countryCode).subscribe({
        next: (response: CountryLanguagesResponse) => {
          this.languages = response.countryLanguages;
        },
        error: (error) => {
          console.error('Error loading languages', error);
          this.errorMessage = 'Failed to load languages.';
        }
      });
    }
  }
}
