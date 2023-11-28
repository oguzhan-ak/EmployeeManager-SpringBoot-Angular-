import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { KorpusOrderComponent } from './korpusOrder.component';

@NgModule({
    imports: [
        RouterModule.forChild([{ path: '', component: KorpusOrderComponent }]),
    ],
    exports: [RouterModule],
})
export class KorpusOrderRoutingModule {}
