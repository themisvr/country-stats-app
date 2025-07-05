export interface CountryEnhancedDto {
  id: number;
  name: string;
  region: Region;
  countryStats: CountryStat[];
}

  export interface CountryStat {
    year: number;
    population: number;
    gdp: number;
  }

  export interface Region {
    id: number;
    name: string;
    continentName: string;
  }