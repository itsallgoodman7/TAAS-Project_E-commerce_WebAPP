import {Component, EventEmitter, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {MusicDeviceOrders} from '../models/musicDevice-orders.model';
import {MusicDeviceOrder} from '../models/musicDevice-order.model';
import {EcommerceService} from '../services/EcommerceService';
import {Subscription} from 'rxjs/internal/Subscription';
import { faCoffee, faPhone, faShoppingCart} from '@fortawesome/free-solid-svg-icons';
import {Router} from '@angular/router';

@Component({
    selector: 'app-shopping-cart',
    templateUrl: './shopping-cart.component.html',
    styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit, OnDestroy {
    faShoppingCart = faShoppingCart;
    orderFinished: boolean;
    orders: MusicDeviceOrders;
    total: number = this.ecommerceService.Total;
    sub: Subscription;

    // tslint:disable-next-line:no-output-on-prefix
    @Output() onOrderFinished: EventEmitter<boolean>;
    constructor(public ecommerceService: EcommerceService, private router: Router) {
        this.total = this.ecommerceService.Total;
        this.orderFinished = false;
        this.onOrderFinished = new EventEmitter<boolean>();
    }

    ngOnInit() {
        this.orders = new MusicDeviceOrders();
        this.loadCart();
        this.loadTotal();
    }


    private calculateTotal(musicDevices: MusicDeviceOrder[]): number {
        let sum = 0;
        musicDevices.forEach(value => {
            sum += (value.musicDevice.price * value.quantity);
        });
        return sum;
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    finishOrder() {
        this.orderFinished = true;
        this.ecommerceService.Total = this.total;
        this.onOrderFinished.emit(this.orderFinished);
        this.router.navigate([':id/payments']);
    }

    loadTotal() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.ecommerceService.Total = this.calculateTotal(this.orders.musicDeviceOrders);
            this.total = this.ecommerceService.Total;
        });
    }

    loadCart() {
        this.sub = this.ecommerceService.MusicDeviceOrderChanged.subscribe(() => {
            const musicDeviceOrder = this.ecommerceService.SelectedMusicDeviceOrder;
            if (musicDeviceOrder) {
                this.orders.musicDeviceOrders.push(new MusicDeviceOrder(
                    musicDeviceOrder.musicDevice, musicDeviceOrder.quantity));
            }
            this.ecommerceService.MusicDeviceOrders = this.orders;
            this.orders = this.ecommerceService.MusicDeviceOrders;
            this.ecommerceService.Total = this.calculateTotal(this.orders.musicDeviceOrders);
            this.total = this.ecommerceService.Total;
        });
    }

    reset() {
        this.orderFinished = false;
        this.orders = new MusicDeviceOrders();
        this.orders.musicDeviceOrders = [];
        this.loadTotal();
        this.total = 0;
    }
}
