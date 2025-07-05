export interface CountryStatistics {
  countryName: string;
  countryCode3: string;
  year: number;
  population: number;
  gdp: number;
}

export interface CountryStatisticsResponse {
  countriesStats: CountryStatistics[];
}
