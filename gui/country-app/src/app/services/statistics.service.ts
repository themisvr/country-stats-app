import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { GetPaginatedStatisticsResponse } from "../models/statistics.model";

@Injectable({ providedIn: 'root' })
export class StatisticsService {
    private baseUrl = 'http://localhost:8080/api';

    constructor(private http: HttpClient) {}

  getStatistics(yearFrom?: number | null, yearTo?: number | null, regionId?: number | null, page: number = 0, size: number = 10) {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    if (yearFrom !== null && yearFrom !== undefined) {
      params = params.append('yearFrom', yearFrom.toString());
    }

    if (yearTo !== null && yearTo !== undefined) {
      params = params.append('yearTo', yearTo.toString());
    }

    if (regionId !== null && regionId !== undefined) {
      params = params.append('regionId', regionId.toString());
    }

    return this.http.get<GetPaginatedStatisticsResponse>(`${this.baseUrl}/statistics`, { params });
  }
}