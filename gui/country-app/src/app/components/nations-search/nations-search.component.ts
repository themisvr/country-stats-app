import { RegionComponent } from './../region/region.component';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NationsSearchService } from '../../services/nations-search.service';
import { FormsModule } from '@angular/forms';
// import { CountryStatistics } from '../models/country-statistics.model';

@Component({
  selector: 'app-nations-search',
  templateUrl: './nations-search.component.html',
  styleUrls: ['./nations-search.component.css'],
  imports: [CommonModule, FormsModule, RegionComponent],
  standalone: true
})
export class NationsSearchComponent implements OnInit {
  // statistics: CountryStatistics[] = [];
  fromYear?: number;
  toYear?: number;
  selectedRegionId?: number;
  errorMessage: string = '';

  constructor(private nationSearchService: NationsSearchService) {}

  ngOnInit(): void {}

  onRegionSelected(regionId: number) {
    this.selectedRegionId = regionId;
  }

  onSearch() {
    // if (!this.fromYear || !this.toYear || !this.selectedRegionId) {
    //   this.errorMessage = 'Please provide all search criteria.';
    //   return;
    // }

    // this.errorMessage = '';
    // this.nationSearchService
    //   .searchStatistics(this.fromYear, this.toYear, this.selectedRegionId)
    //   .subscribe({
    //     next: (response) => {
    //       this.statistics = response.countriesStats;
    //     },
    //     error: (err) => {
    //       console.error(err);
    //       this.errorMessage = 'Failed to load data.';
    //     }
    //   });
  }
}
