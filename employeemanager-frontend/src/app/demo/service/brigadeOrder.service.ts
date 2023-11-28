import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { BrigadeOrder } from '../api/model/brigadeOrder';

@Injectable()
export class BrigadeOrderService {
    private apiServerUrl = environment.apiBaseUrl + '/brigadeOrder';
    constructor(private http: HttpClient) {}

    public getBrigadeOrders(): Observable<BrigadeOrder[]> {
        return this.http.get<BrigadeOrder[]>(`${this.apiServerUrl}/all`);
    }

    public updateBrigadeOrders(
        brigadeOrder: BrigadeOrder
    ): Observable<BrigadeOrder> {
        return this.http.put<BrigadeOrder>(
            `${this.apiServerUrl}/update`,
            brigadeOrder
        );
    }
}
