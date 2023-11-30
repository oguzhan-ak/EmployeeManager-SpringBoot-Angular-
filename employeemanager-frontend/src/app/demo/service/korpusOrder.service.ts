import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { KorpusOrder } from '../api/model/korpusOrder';

@Injectable()
export class KorpusOrderService {
    private apiServerUrl = environment.apiBaseUrl + '/korpusOrder';
    constructor(private http: HttpClient) {}

    public getKorpusOrders(korpusId: number): Observable<KorpusOrder[]> {
        return this.http.get<KorpusOrder[]>(
            `${this.apiServerUrl}/all/${korpusId}`
        );
    }

    // public updateBrigadeOrders(
    //     brigadeOrder: BrigadeOrder
    // ): Observable<BrigadeOrder> {
    //     return this.http.put<BrigadeOrder>(
    //         `${this.apiServerUrl}/update`,
    //         brigadeOrder
    //     );
    // }
}
