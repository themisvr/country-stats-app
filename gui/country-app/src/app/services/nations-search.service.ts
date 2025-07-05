import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface NationStat {
  name: string;
  countryCode3: string;
  year: number;
  population: number;
  gdp: number;
  regionName?: string;
}

@Injectable({
  providedIn: 'root'
})
export class NationsSearchService {
  private apiUrl = 'http://localhost:8080/api/nations/search';

  constructor(private http: HttpClient) {}

  searchNations(fromDate?: string, toDate?: string, regionId?: number): Observable<NationStat[]> {
    let params = new HttpParams();

    if (fromDate) {
      params = params.set('fromDate', fromDate);
    }
    if (toDate) {
      params = params.set('toDate', toDate);
    }
    if (regionId !== undefined && regionId !== null) {
      params = params.set('regionId', regionId.toString());
    }

    return this.http.get<NationStat[]>(this.apiUrl, { params });
  }
}
