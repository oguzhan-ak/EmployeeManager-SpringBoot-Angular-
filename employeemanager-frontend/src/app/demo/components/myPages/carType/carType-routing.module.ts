import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CarTypeComponent } from './carType.component';

@NgModule({
    imports: [
        RouterModule.forChild([{ path: '', component: CarTypeComponent }]),
    ],
    exports: [RouterModule],
})
export class CarTypeRoutingModule {}
