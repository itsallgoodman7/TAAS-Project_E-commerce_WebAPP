import {Component, OnInit, ViewChild} from '@angular/core';
import {FilterpipePipe} from '../../filterpipe.pipe';
import {MusicDevicesComponent} from '../musicDevices/musicDevices.component';
import {EcommerceService} from '../services/EcommerceService';
import {MusicDevice} from '../models/musicDevice.model';
import {faSearch} from '@fortawesome/free-solid-svg-icons';
import {Router} from '@angular/router';

@Component({
    selector: 'app-searchbar',
    templateUrl: './searchbar.component.html',
    styleUrls: ['./searchbar.component.css']
})

export class SearchbarComponent implements OnInit {
    faSearch = faSearch;
    searchText = '';
    musicDevices: MusicDevice[] = [];
    characters = [
        'Ant-Man',
        'Aquaman',
        'Asterix',
        'The Atom',
        'The Avengers',
        'Batgirl',
        'Batman',
        'Batwoman'
    ];
    enterpressed = false;
    filtered = [];
    @ViewChild('musicDevicesC')
    musicDevicesC: MusicDevicesComponent;
    listName: [string, number] [] = [];
    constructor(private ecommerceService: EcommerceService, private r: Router) { }

    ngOnInit(): void {
        this.listName = this.loadMusicDevicesName();
    }
    loadMusicDevicesName() {
        this.ecommerceService.getCategoryUrl(0)
            .subscribe(
                (musicDevices: any[]) => {
                    this.musicDevices = musicDevices;
                    this.musicDevices.forEach(musicDevice => {
                        this.listName.push([musicDevice.name, musicDevice.id]);
                    });
                },
                (error) => console.log(error)
            );
        return this.listName;
    }



    search(searchText: string) {
        this.filtered = new FilterpipePipe().transform(this.listName, searchText);
        this.enterpressed = true;
    }

    setSelectedItem($event: MouseEvent, pr: any) {
        // @ts-ignore
        this.r.navigate(['/' + pr]);
    }

}
