import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { CarType } from '../api/model/carType';

@Injectable()
export class CarTypeService {
    private apiServerUrl = environment.apiBaseUrl + '/carType';
    constructor(private http: HttpClient) {}

    public getCarTypes(): Observable<CarType[]> {
        return this.http.get<CarType[]>(`${this.apiServerUrl}/all`);
    }

    public addCarType(carType: CarType): Observable<CarType> {
        return this.http.post<CarType>(`${this.apiServerUrl}/add`, carType);
    }

    public updateCarType(carType: CarType): Observable<CarType> {
        return this.http.put<CarType>(`${this.apiServerUrl}/update`, carType);
    }

    public deleteCarType(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/delete/${id}`);
    }

    public deleteCarTypes(idList: number[]): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/deleteMultiple`, {
            body: idList,
        });
    }

    public getCarTypeById(id: number): Observable<CarType> {
        return this.http.get<CarType>(`${this.apiServerUrl}/find/${id}`);
    }
}
