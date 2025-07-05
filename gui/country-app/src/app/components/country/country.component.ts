import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { Country } from '../../models/country.model';

@Component({
  selector: 'app-country',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './country.component.html',
  styleUrl: './country.component.css'
})
export class CountryComponent implements OnInit {
  countries: Country[] = [];

  constructor(
    private countryService: CountryService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.countryService.getCountries().subscribe({
      next: (data) => {
        if (data && Array.isArray(data.countries)) {
          this.countries = data.countries;
        } else {
          console.error('Unexpected data format:', data);
        }
      },
      error: (err) => {
        console.error('Error fetching countries:', err);
      }
    });
  }

  onCountryClick(code: string, countryName: string): void {
    this.router.navigate(['/countries', code, 'languages'],
    {queryParams: { countryName }});
  }
}
