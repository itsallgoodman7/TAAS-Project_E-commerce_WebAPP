import {Component, OnInit, ViewChild} from '@angular/core';
import {MusicDeviceOrders} from '../models/musicDevice-orders.model';
import {Subscription} from 'rxjs/internal/Subscription';
import {EcommerceService} from '../services/EcommerceService';
import {ShoppingCartComponent} from '../shopping-cart/shopping-cart.component';

@Component({
    selector: 'app-orders',
    templateUrl: './orders.component.html',
    styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
    orders: MusicDeviceOrders;
    total: number;
    paid: boolean;
    sub: Subscription;

    @ViewChild('sc')
    sc: ShoppingCartComponent;

    constructor(public ecommerceService: EcommerceService) {
        this.orders = this.ecommerceService.MusicDeviceOrders;
    }

    ngOnInit() {
        this.paid = false;
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.orders = this.ecommerceService.MusicDeviceOrders;
        });
        this.loadTotal();
    }

    pay() {
        if (this.ecommerceService.isLogged()) {
            this.paid = true;
            this.ecommerceService.saveOrder(this.orders).subscribe();
            this.ecommerceService.MusicDeviceOrders.musicDeviceOrders = [];
            this.ecommerceService.Total = 0;
        } else {
            alert('Per completare l\' acquisto è richiesto il Login');
        }
    }

    loadTotal() {
        this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
            this.total = this.ecommerceService.Total;
        });
    }
}
