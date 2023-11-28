import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrigadeOrderComponent } from './brigadeOrder.component';

@NgModule({
    imports: [
        RouterModule.forChild([{ path: '', component: BrigadeOrderComponent }]),
    ],
    exports: [RouterModule],
})
export class BrigadeOrderRoutingModule {}
