import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { BrigadeOrder } from 'src/app/demo/api/model/brigadeOrder';
import { Rank } from 'src/app/demo/api/model/rank';
import { BrigadeOrderService } from 'src/app/demo/service/brigadeOrder.service';

@Component({
    templateUrl: './brigadeOrder.component.html',
    providers: [MessageService],
})
export class BrigadeOrderComponent implements OnInit {
    brigadeOrders: BrigadeOrder[] = [];

    rankColumns: any[] = [
        { field: 'SERGEANT', header: 'Sergeant' },
        { field: 'PETTY_OFFICER', header: 'Petty Officer' },
        { field: 'SOLDIER', header: 'Soldier' },
    ];

    rowsPerPageOptions = [5, 10, 20];

    getRankValue(rowData: BrigadeOrder, field: string): number {
        var rank = rowData.ranks.filter(
            (rank: Rank) => rank.rankType === field
        );
        if (rank.length > 0) {
            return rank[0].amount;
        }
        return 0;
    }

    constructor(
        private brigadeOrderService: BrigadeOrderService,
        private messageService: MessageService
    ) {}

    ngOnInit() {
        this.getBrigadeOrders();
    }

    getBrigadeOrders(): void {
        this.brigadeOrderService.getBrigadeOrders().subscribe({
            next: (brigadeOrders: BrigadeOrder[]) => {
                this.brigadeOrders = brigadeOrders;
            },
            error: (error: HttpErrorResponse) => {
                alert(error.message);
            },
        });
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal(
            (event.target as HTMLInputElement).value,
            'contains'
        );
    }
}
