import { PaginatedResponse } from "./paginated-response-interface.model";

export interface CountryStatId {
    countryId: number;
    year: number;
}


export interface Statistics {
  id: CountryStatId;
  countryName: string;
  regionName: string;
  continentName: string;
  year: number;
  population: number;
  gdp: number;
}


export interface GetPaginatedStatisticsResponse {
  stats: PaginatedResponse<Statistics>;
}