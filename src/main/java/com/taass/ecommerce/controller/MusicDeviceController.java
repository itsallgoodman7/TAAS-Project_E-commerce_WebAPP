package com.taass.ecommerce.controller;

import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import com.taass.ecommerce.service.MusicDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicDeviceController {

    private MusicDeviceService musicDeviceService;

    public MusicDeviceController(MusicDeviceService musicDeviceService) {
        this.musicDeviceService = musicDeviceService;
    }

    @GetMapping("/musicDevices")
    public @NotNull Iterable<MusicDevice> getMusicDevices() {
        return musicDeviceService.getAllMusicDevices();
    }
    @GetMapping("/test")
    public @NotNull String getProva() {
        return "test ok";
    }

    @PostMapping ("/musicDevices")
    public @NotNull MusicDevice putMusicDevice(@RequestBody MusicDevice p) {
        return musicDeviceService.save(p);
    }

    @GetMapping("/musicDevices/{category}")
    public @NotNull Iterable<MusicDevice> getMusicDevicesByCategory(@PathVariable("category")MusicDeviceCategories category) {
        return musicDeviceService.findByCategory(category);
    }
    @GetMapping("/musicDevices/{p1}/-/{p2}")
    public @NotNull Iterable<MusicDevice> getMusicDevicesByRange(@PathVariable("p1")double p1,@PathVariable("p2")double  p2) {
        return musicDeviceService.findByRange(p1, p2);
    }

    @GetMapping("/musicDevices/{category}/{p1}/{p2}")
    public @NotNull Iterable<MusicDevice> getMusicDeviceByCatRange(@PathVariable("p1")double p1,@PathVariable("p2")double  p2,@PathVariable("category")MusicDeviceCategories category ) {
        return musicDeviceService.findByCatRange(p1, p2, category);
    }

    @GetMapping("/musicDevices/id/{id}")
    public @NotNull MusicDevice getMusicDevicesById( @PathVariable("id") long id){
        return musicDeviceService.getMusicDevice(id);
    }

    @GetMapping("/musicDevices/search={name}")
    public @NotNull Iterable<MusicDevice> findByName(@PathVariable("name") String name) {
        return musicDeviceService.findByNameContainingIgnoreCase(name);
    }

    @DeleteMapping("/musicDevices/{id}")
    public ResponseEntity<String> deleteMusicDevice(@PathVariable("id") long id) {
        System.out.println("Delete MusicDevice with ID = " + id + "...");

        musicDeviceService.deleteMusicDeviceByID(id);

        return new ResponseEntity<>("MusicDevice has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/musicDevices/delete")
    public ResponseEntity<String> deleteAllMusicDevices() {
        System.out.println("Delete All MusicDevices...");

        musicDeviceService.deleteAllMusicDevices();

        return new ResponseEntity<>("All MusicDevices have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<MusicDevice> updateMusicDeviceByID(@PathVariable("id") long id, @RequestBody MusicDevice musicDevice) {
        System.out.println("Update MusicDevice with ID = " + id + "...");

        Optional<MusicDevice> musicDeviceData = Optional.ofNullable(musicDeviceService.getMusicDevice(id));

        if (musicDeviceData.isPresent()) {
            MusicDevice _musicDevice = musicDeviceData.get();
            _musicDevice.setName(musicDevice.getName());
            _musicDevice.setPrice(musicDevice.getPrice());
            _musicDevice.setPictureUrl(musicDevice.getPictureUrl());
            _musicDevice.setCategory(musicDevice.getCategory());
            return new ResponseEntity<>(musicDeviceService.save(_musicDevice), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
