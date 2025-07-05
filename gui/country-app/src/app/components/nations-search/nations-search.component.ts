import { PaginatedResponse } from '../../models/paginated-response-interface.model';
import { CountryEnhancedDto } from './../../models/country-enhanced-response.model';
import { CountryService } from './../../services/country.service';
import { RegionComponent } from './../region/region.component';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-nations-search',
  templateUrl: './nations-search.component.html',
  styleUrls: ['./nations-search.component.css'],
  imports: [CommonModule, FormsModule, RegionComponent],
  standalone: true
})
export class NationsSearchComponent implements OnInit {
  countriesFiltered: CountryEnhancedDto[] = [];
  fromYear?: number;
  toYear?: number;
  selectedRegionId?: number | null;
  errorMessage: string = '';

  currentPage: number = 0;
  pageSize: number = 10;
  totalPages: number = 0;

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {}

  onRegionSelected(regionId: number | null) {
    this.selectedRegionId = regionId;
  }

  onSearch(page: number = 0): void {
    this.errorMessage = '';
    this.currentPage = page;

    this.countryService.getCountriesRegions(this.fromYear, this.toYear, this.selectedRegionId, this.currentPage, this.pageSize)
      .subscribe({
        next: (response: PaginatedResponse<CountryEnhancedDto>) => {
          this.countriesFiltered = response.content;
          this.totalPages = response.page.totalPages;
        },
        error: (err) => {
          this.errorMessage = 'Failed to load countries. Please try again later.';
          console.error('Search error:', err);
        }
      });
    }

  onPageChange(newPage: number) {
    this.onSearch(newPage);
  }

  nextPage(): void {
    if (this.currentPage + 1 < this.totalPages) {
      this.currentPage++;
      this.onSearch(this.currentPage);
    }
  }

  prevPage(): void {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.onSearch(this.currentPage);
    }
  }

}
