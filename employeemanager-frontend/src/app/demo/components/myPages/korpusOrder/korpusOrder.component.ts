import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Table } from 'primeng/table';
import { BrigadeOrder } from 'src/app/demo/api/model/brigadeOrder';
import { Rank } from 'src/app/demo/api/model/rank';
import { BrigadeOrderService } from 'src/app/demo/service/brigadeOrder.service';

@Component({
    templateUrl: './korpusOrder.component.html',
    providers: [MessageService],
})
export class KorpusOrderComponent implements OnInit {
    brigadeOrders: BrigadeOrder[] = [];
    clonedBrigadeOrders: { [s: string]: BrigadeOrder } = {};
    loading: boolean = false;

    rankColumns: any[] = [
        { field: 'PETTY_OFFICER', index: 0, header: 'Petty Officer' },
        { field: 'SERGEANT', index: 1, header: 'Sergeant' },
        { field: 'SOLDIER', index: 2, header: 'Soldier' },
    ];

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
        this.loading = true;
        this.brigadeOrderService.getBrigadeOrders().subscribe({
            next: (brigadeOrders: BrigadeOrder[]) => {
                this.brigadeOrders = brigadeOrders;
            },
            error: (error: HttpErrorResponse) => {
                alert(error.message);
            },
            complete: () => {
                this.loading = false;
            },
        });
    }

    updateBrigadeOrder(brigadeOrder: BrigadeOrder): void {
        this.brigadeOrderService.updateBrigadeOrders(brigadeOrder).subscribe({
            next: (brigadeOrder: BrigadeOrder) => {
                delete this.clonedBrigadeOrders[brigadeOrder.id.toString()];
                this.messageService.add({
                    severity: 'success',
                    summary: 'Success',
                    detail: 'Brigade Order is updated',
                });
                this.getBrigadeOrders();
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

    onRowEditInit(brigadeOrder: BrigadeOrder) {
        this.clonedBrigadeOrders[brigadeOrder.id.toString()] = JSON.parse(
            JSON.stringify(brigadeOrder)
        );
    }

    onRowEditSave(brigadeOrder: BrigadeOrder) {
        if (
            brigadeOrder.ranks[0].amount >= 0 &&
            brigadeOrder.ranks[1].amount >= 0 &&
            brigadeOrder.ranks[2].amount >= 0
        ) {
            this.updateBrigadeOrder(brigadeOrder);
        } else {
            this.messageService.add({
                severity: 'error',
                summary: 'Error',
                detail: 'Invalid Amount',
            });
        }
    }

    onRowEditCancel(brigadeOrder: BrigadeOrder, index: number) {
        var copy = JSON.parse(JSON.stringify(this.brigadeOrders));
        copy[index] = JSON.parse(
            JSON.stringify(this.clonedBrigadeOrders[brigadeOrder.id.toString()])
        );
        this.brigadeOrders = copy;
        delete this.clonedBrigadeOrders[brigadeOrder.id.toString()];
    }
}
