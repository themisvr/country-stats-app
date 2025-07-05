import { RegionResponse } from './../models/region.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Region {
  id: number;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class RegionService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getRegions(): Observable<RegionResponse> {
    return this.http.get<RegionResponse>(`${this.baseUrl}/regions`);
  }
}
