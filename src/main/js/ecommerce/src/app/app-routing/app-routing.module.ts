import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EcommerceComponent} from '../ecommerce/ecommerce.component';
import {MusicDevicedescriptionComponent} from '../ecommerce/musicDevicedescription/musicDevicedescription.component';
import {AppComponent} from '../app.component';
import {OrdersComponent} from '../ecommerce/orders/orders.component';



const routes: Routes = [
    {path: '', component: EcommerceComponent},
    {path: ':id', component: MusicDevicedescriptionComponent},
    {path: ':id/payments', component: OrdersComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
