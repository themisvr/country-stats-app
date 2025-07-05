import { NationStat } from './country-enhanced-response.model';
import { PaginatedResponse } from './paginated-response-interface.model';

export interface CountriesRegionsResponse extends PaginatedResponse<NationStat> {}