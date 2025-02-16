import {Component, OnInit, ViewChild} from '@angular/core';
import { Options, LabelType } from '@angular-slider/ngx-slider';
import {EcommerceService} from '../services/EcommerceService';
import {MusicDevicesComponent} from '../musicDevices/musicDevices.component';
import {SlideshowComponent} from '../slideshow/slideshow.component';
import {ShoppingCartComponent} from '../shopping-cart/shopping-cart.component';
import {OrdersComponent} from '../orders/orders.component';
import {MusicDeviceOrder} from '../models/musicDevice-order.model';
import {MusicDevice} from '../models/musicDevice.model';

@Component({
  selector: 'app-rangebar',
  templateUrl: './rangebar.component.html',
  styleUrls: ['./rangebar.component.css']
})
export class RangebarComponent implements OnInit {
    @ViewChild('musicDevicesC')
    musicDevicesC: MusicDevicesComponent;

    @ViewChild('slideC')
    slideC: SlideshowComponent;

    @ViewChild('shoppingCartC')
    shoppingCartC: ShoppingCartComponent;

    @ViewChild('ordersC')
    musicDevices: MusicDevice[] = [];
    ordersC: OrdersComponent;
    value = 0;
    highvalue = 3000;
    options: Options = {
        floor: 0,
        ceil: 3000,
        showSelectionBar: true,
        translate: (value: number, label: LabelType): string => {
            switch (label) {
                case LabelType.Low:
                    return '<b>Min price:</b> $' + value;
                case LabelType.High:
                    return '<b>Max price:</b> $' + value;
                default:
                    return '$' + value;
            }
        },
        getPointerColor: (): string => {
            return '#000000';
        }
    };
    loadMusicDevicesByRange(i: number, min: number, max: number) {
        this.ecommerceService.musicDeviceOrders2 = [];
        this.ecommerceService.getMusicDeviceByRange(min, max, i)
            .subscribe(
                (musicDevices: any[]) => {
                    this.musicDevices = musicDevices;
                    this.musicDevices.forEach(musicDevice => {
                        this.ecommerceService.musicDeviceOrders2.push(new MusicDeviceOrder(musicDevice, 0));
                    });
                },
                (error) => console.log(error)
            );
    }
    sliderEvent() {
        this.loadMusicDevicesByRange( this.ecommerceService.category, this.value, this.highvalue);
    }

  constructor(private ecommerceService: EcommerceService) { }

  ngOnInit(): void { }

}
