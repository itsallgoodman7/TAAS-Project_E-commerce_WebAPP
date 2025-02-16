import {MusicDeviceOrder} from '../models/musicDevice-order.model';
import {Subject} from 'rxjs/internal/Subject';
import {MusicDeviceOrders} from '../models/musicDevice-orders.model';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';


@Injectable()
export class EcommerceService {
    private musicDevicesUrl = '/api/musicDevices';
    private ordersUrl = '/api/orders';
    Urls = ['/api/musicDevices', '/api/musicDevices/Consumer', '/api/musicDevices/Acoustic', '/api/musicDevices/MIDIProduction'];

    private musicDeviceOrder: MusicDeviceOrder;
    private orders: MusicDeviceOrders = new MusicDeviceOrders();

    private musicDeviceOrderSubject = new Subject();
    private ordersSubject = new Subject();
    private totalSubject = new Subject();
    private _category = 1;
    private _musicDeviceOrders2: MusicDeviceOrder[] = [];
    total: number;
    ss = false;
    valueSource: Subject<boolean> = new Subject();
    MusicDeviceOrderChanged = this.musicDeviceOrderSubject.asObservable();
    OrdersChanged = this.ordersSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();
    public isLoggedin = false;

    constructor(private http: HttpClient) {
    }

    async getAllMusicDevices() {
        return this.http.get(this.musicDevicesUrl);
    }
    getURLIndex(id: number) {
        console.log(id);
        let str = '';
        return str += this.musicDevicesUrl + '/id/' + String(id);
    }
    getMusicDevicebyID(id: number) {
        return this.http.get(this.getURLIndex(id));
    }
    getCategoryUrl(i: number) {
        return this.http.get(this.Urls[i]);
    }
    saveOrder(order: MusicDeviceOrders) {
        return this.http.post(this.ordersUrl, order);
    }

    set SelectedMusicDeviceOrder(value: MusicDeviceOrder) {
        this.musicDeviceOrder = value;
        this.musicDeviceOrderSubject.next();
    }

    get SelectedMusicDeviceOrder() {
        return this.musicDeviceOrder;
    }

    set MusicDeviceOrders(value: MusicDeviceOrders) {
        this.orders = value;
        this.ordersSubject.next();
    }

    get MusicDeviceOrders() {
        return this.orders;
    }

    get Total() {
        if (this.total > 0) {
            return Math.round(this.total * 100) / 100;
        } else {return 0; }
    }

    set Total(value: number) {
        this.total = value;
        this.totalSubject.next();
    }
    changeTotal(value: number) {
        this.total = value;
        this.totalSubject.next();
    }

    changeFoo(ss: boolean) {
        this.valueSource.next(ss);
    }
    getMusicDeviceByRange(min: number, max: number, category: number) {
        if (category === 0) {
            return this.http.get(this.Urls[category] + '/' + min + '/-/' + max);
        } else {
            return this.http.get(this.Urls[category] + '/' + min + '/' + max);
        }
    }
    get category(): number {
        return this._category;
    }

    set category(value: number) {
        this._category = value;
    }
    get musicDeviceOrders2(): MusicDeviceOrder[] {
        return this._musicDeviceOrders2;
    }

    set musicDeviceOrders2(value: MusicDeviceOrder[]) {
        this._musicDeviceOrders2 = value;
    }
    isLogged() {
        return this.isLoggedin;
    }
}
