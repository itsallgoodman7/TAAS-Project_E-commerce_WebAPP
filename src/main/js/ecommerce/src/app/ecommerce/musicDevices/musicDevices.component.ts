import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MusicDeviceOrder} from '../models/musicDevice-order.model';
import {EcommerceService} from '../services/EcommerceService';
import {Subscription} from 'rxjs/internal/Subscription';
import {MusicDevice} from '../models/musicDevice.model';
import {faPlus, faMinus} from '@fortawesome/free-solid-svg-icons';

@Component({
    selector: 'app-musicDevices',
    templateUrl: './musicDevices.component.html',
    styleUrls: ['./musicDevices.component.css']
})
export class MusicDevicesComponent implements OnInit {
    musicDeviceOrders: MusicDeviceOrder[] = [];
    musicDevices: MusicDevice[] = [];
    selectedMusicDeviceOrder: MusicDeviceOrder;
    sub: Subscription;
    musicDeviceSelected = false;
    listName: string[] = [];
    faMinus = faMinus;
    faPlus = faPlus;


    constructor(public ecommerceService: EcommerceService) {

    }

    ngOnInit() {
        this.musicDeviceOrders = [];
    }
    addToCart(order: MusicDeviceOrder) {
        this.ecommerceService.SelectedMusicDeviceOrder = order;
        this.selectedMusicDeviceOrder = this.ecommerceService.SelectedMusicDeviceOrder;
        // rimozione
        this.musicDeviceSelected = true;
    }

    removeFromCart(musicDeviceOrder: MusicDeviceOrder) {
        const index = this.getMusicDeviceIndex(musicDeviceOrder.musicDevice);
        if (index > -1) {
            this.ecommerceService.MusicDeviceOrders.musicDeviceOrders.splice(
                this.getMusicDeviceIndex(musicDeviceOrder.musicDevice), 1);
        }
        console.log(this.calculateTotal(this.ecommerceService.MusicDeviceOrders.musicDeviceOrders));
        this.ecommerceService.changeTotal((this.calculateTotal(this.ecommerceService.MusicDeviceOrders.musicDeviceOrders)));
       this.musicDeviceSelected = false;
    }

    getMusicDeviceIndex(musicDevice: MusicDevice): number {
        return this.ecommerceService.MusicDeviceOrders.musicDeviceOrders.findIndex(
            value => value.musicDevice.id === musicDevice.id);
    }

    isMusicDeviceSelected(musicDevice: MusicDevice): boolean {
        return this.getMusicDeviceIndex(musicDevice) > -1;
    }


    loadMusicDevices(i: number) {
        this.ecommerceService.musicDeviceOrders2 = [];
        this.ecommerceService.getCategoryUrl(i)
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

    private calculateTotal(musicDevices: MusicDeviceOrder[]): number {
        let sum = 0;
        musicDevices.forEach(value => {
            sum += (value.musicDevice.price * value.quantity);
        });
        return sum;
    }
    reset() {
        this.musicDeviceOrders = [];
        this.loadMusicDevices(0);
        this.ecommerceService.MusicDeviceOrders.musicDeviceOrders = [];
        this.musicDeviceSelected = false;
    }
}
