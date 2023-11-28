import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { CarType } from 'src/app/demo/api/model/carType';
import { CarTypeService } from 'src/app/demo/service/carType.service';

@Component({
    templateUrl: './carType.component.html',
    providers: [MessageService],
})
export class CarTypeComponent implements OnInit {
    carTypeDialog: boolean = false;

    deleteCarTypeDialog: boolean = false;

    deleteCarTypesDialog: boolean = false;

    carTypes: CarType[] = [];

    carType: CarType = {};

    selectedCarTypes: CarType[] = [];

    submitted: boolean = false;

    cols: any[] = [
        { field: 'code', header: 'Code' },
        { field: 'name', header: 'Name' },
        { field: 'description', header: 'Description' },
    ];

    rowsPerPageOptions = [5, 10, 20];

    constructor(
        private carTypeService: CarTypeService,
        private messageService: MessageService
    ) {}

    ngOnInit() {
        this.getCarTypes();
    }

    getCarTypes(): void {
        this.carTypeService.getCarTypes().subscribe({
            next: (carTypes: CarType[]) => {
                this.carTypes = carTypes;
            },
            error: (error: HttpErrorResponse) => {
                alert(error.message);
            },
        });
    }

    openNew() {
        this.carType = {};
        this.submitted = false;
        this.carTypeDialog = true;
    }

    deleteSelectedCarTypes() {
        this.deleteCarTypesDialog = true;
    }

    editCarType(carType: CarType) {
        this.carType = { ...carType };
        this.carTypeDialog = true;
    }

    deleteCarType(carType: CarType) {
        this.deleteCarTypeDialog = true;
        this.carType = { ...carType };
    }

    confirmDeleteSelected() {
        var selectedCarTypeIdList = this.carTypes
            .filter((val) => this.selectedCarTypes.includes(val))
            .map((carType: CarType) => carType.id);

        if (selectedCarTypeIdList.length > 0) {
            this.carTypeService
                .deleteCarTypes(selectedCarTypeIdList)
                .subscribe({
                    next: (response: void) => {
                        this.getCarTypes();

                        this.deleteCarTypesDialog = false;

                        this.messageService.add({
                            severity: 'success',
                            summary: 'Successful',
                            detail: 'Car Types Deleted',
                            life: 3000,
                        });
                        this.selectedCarTypes = [];
                    },
                    error: (error: HttpErrorResponse) => {
                        alert(error.message);
                    },
                });
        }
    }

    confirmDelete() {
        this.carTypeService.deleteCarType(this.carType.id).subscribe({
            next: (response: void) => {
                this.getCarTypes();
                this.deleteCarTypeDialog = false;
                this.messageService.add({
                    severity: 'success',
                    summary: 'Successful',
                    detail: 'Car Type Deleted',
                    life: 3000,
                });
                this.carType = {};
            },
            error: (error: HttpErrorResponse) => {
                alert(error.message);
            },
        });
    }

    hideDialog() {
        this.carTypeDialog = false;
        this.submitted = false;
    }

    saveCarType() {
        this.submitted = true;
        if (this.carType.name?.trim() && this.carType.code?.trim()) {
            if (this.carType.id) {
                this.carTypeService.updateCarType(this.carType).subscribe({
                    next: (carType: CarType) => {
                        this.getCarTypes();
                        this.messageService.add({
                            severity: 'success',
                            summary: 'Successful',
                            detail: 'Car Type Updated',
                            life: 3000,
                        });
                    },
                    error: (error: HttpErrorResponse) => {
                        alert(error.message);
                    },
                });
            } else {
                this.carTypeService.addCarType(this.carType).subscribe({
                    next: (carType: CarType) => {
                        this.getCarTypes();

                        this.messageService.add({
                            severity: 'success',
                            summary: 'Successful',
                            detail: 'Car Type Created',
                            life: 3000,
                        });
                    },
                    error: (error: HttpErrorResponse) => {
                        alert(error.message);
                    },
                });
            }
            this.carTypeDialog = false;
            this.carType = {};
        }
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal(
            (event.target as HTMLInputElement).value,
            'contains'
        );
    }
}
