import { Component, OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { CountryStatistics, CountryStatisticsResponse } from '../../models/country-statistics.model';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-countries-statistics',
  templateUrl: './countries-statistics.component.html',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  styleUrls: ['./countries-statistics.component.css']
})
export class CountriesStatisticsComponent implements OnInit {

  statistics: CountryStatistics[] = [];
  errorMessage: string = '';

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.countryService.getCountryStatistics().subscribe({
      next: (response: CountryStatisticsResponse) => {
        this.statistics = response.countriesStats;
      },
      error: (err) => {
        this.errorMessage = 'Failed to load country statistics';
        console.error(err);
      }
    });
  }
}
