import {Component, OnInit, ViewChild} from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {MusicDevice} from '../models/musicDevice.model';
import {EcommerceService} from '../services/EcommerceService';
import {MusicDeviceOrder} from '../models/musicDevice-order.model';
import {MusicDeviceOrders} from '../models/musicDevice-orders.model';
import {Subscription} from 'rxjs/internal/Subscription';


@Component({
  selector: 'app-musicDevicedescription',
  templateUrl: './musicDevicedescription.component.html',
  styleUrls: ['./musicDevicedescription.component.css'],
})
export class MusicDevicedescriptionComponent implements OnInit {
    id: number;
    inItems: MusicDevice;
    musicDeviceOrder: MusicDeviceOrder;
    orderFinished = false;
    musicDeviceSelected = false;

    sub: Subscription;
    selectedMusicDeviceOrder: MusicDeviceOrder;
    constructor(private activeRoute: ActivatedRoute, private ecommerceService: EcommerceService) { }
     ngOnInit() {

        this.activeRoute.params.subscribe(
            (params: Params) => {
                this.id = params.id;
            }
        );
         this.loadItem(this.id);
    }

    isMusicDeviceSelected(musicDevice: MusicDevice): boolean {
        return this.getMusicDeviceIndex(musicDevice) > -1;
    }
    getMusicDeviceIndex(musicDevice: MusicDevice): number {
        return this.ecommerceService.MusicDeviceOrders.musicDeviceOrders.findIndex(
            value => value.musicDevice.id === musicDevice.id);
    }
    addToCart(order: MusicDeviceOrder) {
        this.ecommerceService.SelectedMusicDeviceOrder = order;
        this.selectedMusicDeviceOrder = this.ecommerceService.SelectedMusicDeviceOrder;
        // tslint:disable-next-line:comment-format
        //rimozione
        this.musicDeviceSelected = true;
    }
    removeFromCart(musicDeviceOrder: MusicDeviceOrder) {
        const index = this.getMusicDeviceIndex(this.inItems);
        if (index > -1) {
            this.ecommerceService.MusicDeviceOrders.musicDeviceOrders.splice(
                this.getMusicDeviceIndex(musicDeviceOrder.musicDevice), 1);
        }
        this.ecommerceService.changeTotal(this.calculateTotal(this.ecommerceService.MusicDeviceOrders.musicDeviceOrders));
        this.musicDeviceSelected = false;
    }

    private calculateTotal(musicDevices: MusicDeviceOrder[]): number {
        let sum = 0;
        musicDevices.forEach(value => {
            sum += (value.musicDevice.price * value.quantity);
        });
        return sum;
    }
    loadItem(id: number) {
           this.ecommerceService.getMusicDevicebyID(this.id).subscribe((data) => {
               console.log(data);
               this.id = data['id'];
              this.inItems = new MusicDevice(data['id'], data['name'], data['price'], data['pictureUrl'], data['category'], data['description']);
              this.musicDeviceOrder = new MusicDeviceOrder(this.inItems, 0);
         } );
     }

}
