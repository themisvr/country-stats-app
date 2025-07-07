import { GetPaginatedStatisticsResponse, Statistics } from './../../models/statistics.model';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegionComponent } from '../region/region.component';
import { CommonModule } from '@angular/common';
import { StatisticsService } from '../../services/statistics.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-statistics',
  standalone: true,
  imports: [CommonModule, FormsModule, RegionComponent],
  templateUrl: './statistics.component.html',
  styleUrl: './statistics.component.css'
})
export class StatisticsComponent implements OnInit {

  statistics: Statistics[] = [];
  fromYear?: number | null;
  toYear?: number | null;
  selectedRegionId?: number | null;
  errorMessage: string = '';

  currentPage: number = 0;
  pageSize: number = 10;
  totalPages: number = 0;
  totalElements: any;

  constructor(private statisticsService: StatisticsService) {}

  ngOnInit(): void {}

  onRegionSelected(regionId: number | null) {
    this.selectedRegionId = regionId;
  }

  onSearch(page: number = 0): void {
    this.errorMessage = '';
    this.currentPage = page;

    this.statisticsService.getStatistics(this.fromYear, this.toYear, this.selectedRegionId, this.currentPage, this.pageSize)
      .subscribe({
        next: (response: GetPaginatedStatisticsResponse) => {
          console.log(response);
          const paginatedData = response.stats;
          this.statistics = paginatedData.content;

          this.currentPage = paginatedData.page.number;
          this.totalElements = paginatedData.page.totalElements;
          this.totalPages = paginatedData.page.totalPages;
          this.pageSize = paginatedData.page.size;
        },
        error: (err: HttpErrorResponse) => {
          if (err.status === 400 && err.error) {
            const errorBody = err.error;
            
            if (errorBody.error === "Invalid Year Range" && errorBody.message) {
              this.errorMessage = errorBody.message;
            } else if (errorBody.message) {
              this.errorMessage = errorBody.message;
            } else {
              this.errorMessage = 'A bad request occurred. Please check your input.';
            }
          } else if (err.status >= 500) {
            this.errorMessage = 'A server error occurred. Please try again later.';
          } else {
            this.errorMessage = 'Failed to load countries due to an unexpected error';
          }
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