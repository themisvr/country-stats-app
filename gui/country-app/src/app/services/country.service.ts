import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CountriesResponse } from '../models/countries-response.model';
import { CountryLanguagesResponse } from '../models/language.model';
import { CountryStatisticsResponse } from '../models/country-statistics.model';
import { CountryEnhancedDto } from '../models/country-enhanced-response.model';
import { PaginatedResponse } from '../models/paginated-response-interface.model';

@Injectable({ providedIn: 'root' })
export class CountryService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getCountries(): Observable<CountriesResponse> {
    return this.http.get<CountriesResponse>(`${this.baseUrl}/countries`);
  }

  getLanguages(countryCode2: string): Observable<CountryLanguagesResponse> {
    return this.http.get<CountryLanguagesResponse>(`${this.baseUrl}/countries/${countryCode2}/languages`);
  }

  getCountryStatistics(): Observable<CountryStatisticsResponse> {
    return this.http.get<CountryStatisticsResponse>(`${this.baseUrl}/countries/statistics`);
  }

  getCountriesRegions(fromYear?: number, toYear?: number, regionId?: number | null, page: number = 0, size: number = 10) {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    if (fromYear !== undefined) params = params.set('yearFrom', fromYear.toString());
    if (toYear !== undefined) params = params.set('yearTo', toYear.toString());
    if (regionId != null) {
      params = params.set('regionId', regionId.toString());
    }

    return this.http.get<PaginatedResponse<CountryEnhancedDto>>(`${this.baseUrl}/countries/regions`, { params });
  }

}
