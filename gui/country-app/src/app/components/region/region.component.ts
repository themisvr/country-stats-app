import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RegionService } from './../../services/region.service';
import { Region, RegionResponse } from './../../models/region.model';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-region-selector',
  templateUrl: './region.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class RegionComponent implements OnInit {
  regions: Region[] = [];
  selectedRegionId: number | null = null;

  @Output() regionSelected = new EventEmitter<number>();

  constructor(private regionService: RegionService) {}

  ngOnInit() {
    this.regionService.getRegions().subscribe({
      next: (data: RegionResponse) => {
        this.regions = data.regions;
        console.log('Regions loaded:', this.regions);
      },
      error: (err) => {
        console.error('Failed to load regions', err);
      }
    });
  }

  onRegionChange(event: Event): void {
    const value = (event.target as HTMLSelectElement).value;
    this.selectedRegionId = Number(value);
    this.regionSelected.emit(this.selectedRegionId);
  }

}
