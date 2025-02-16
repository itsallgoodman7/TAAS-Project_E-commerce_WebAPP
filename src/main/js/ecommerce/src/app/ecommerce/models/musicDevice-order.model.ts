import {MusicDevice} from './musicDevice.model';

export class MusicDeviceOrder {
    musicDevice: MusicDevice;
    quantity: number;

    constructor(musicDevice: MusicDevice, quantity: number) {
        this.musicDevice = musicDevice;
        this.quantity = quantity;
    }

    getMusicDevice() {
        return this.musicDevice;
    }
}
