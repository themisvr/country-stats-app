export interface CountryLanguage {
  languageName: string;
  official: boolean;
}

export interface CountryLanguagesResponse {
  countryLanguages: CountryLanguage[];
}
