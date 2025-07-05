import { NationsSearchComponent } from './components/nations-search/nations-search.component';
import { CountriesLanguagesComponent } from './components/countries-languages/countries-languages.component';
import { CountriesStatisticsComponent } from './components/countries-statistics/countries-statistics.component';
import { CountryComponent } from './components/country/country.component';
import { HomeComponent } from './components/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'countries', component: CountryComponent },
    { path: 'countries/:code/languages', component: CountriesLanguagesComponent },
    { path: 'countries/statistics', component: CountriesStatisticsComponent },
    { path: 'nations', component: NationsSearchComponent },
    { path: '**', redirectTo: '' }
];
