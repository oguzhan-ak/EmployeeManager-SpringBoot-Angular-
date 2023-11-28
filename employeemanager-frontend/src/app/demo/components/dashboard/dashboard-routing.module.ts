import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard.component';

@NgModule({
    imports: [
        RouterModule.forChild([
            { path: '', component: DashboardComponent },
            {
                path: 'carType',
                loadChildren: () =>
                    import('../myPages/carType/carType.module').then(
                        (m) => m.CarTypeModule
                    ),
            },
            {
                path: 'brigadeOrder',
                loadChildren: () =>
                    import('../myPages/brigadeOrder/brigadeOrder.module').then(
                        (m) => m.BrigadeOrderModule
                    ),
            },
            {
                path: 'korpusOrder',
                loadChildren: () =>
                    import('../myPages/korpusOrder/korpusOrder.module').then(
                        (m) => m.KorpusOrderModule
                    ),
            },
        ]),
    ],
    exports: [RouterModule],
})
export class DashboardsRoutingModule {}
