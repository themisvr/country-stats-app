import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CountriesResponse } from '../models/countries-response.model';
import { CountryLanguagesResponse } from '../models/language.model';
import { CountryStatisticsResponse } from '../models/country-statistics.model';

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
}
