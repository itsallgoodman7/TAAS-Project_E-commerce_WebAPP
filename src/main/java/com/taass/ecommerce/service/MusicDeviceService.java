package com.taass.ecommerce.service;

import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface MusicDeviceService {

    @NotNull Iterable<MusicDevice> getAllMusicDevices();

    void deleteAllMusicDevices();
    void deleteMusicDeviceByID(long id);

    Iterable<MusicDevice> findByCategory(MusicDeviceCategories category);

    Iterable<MusicDevice> findByRange(double p1, double p2);

    Iterable<MusicDevice> findByCatRange(double p1, double p2, MusicDeviceCategories category);

    Iterable<MusicDevice> findByNameContainingIgnoreCase(String name);


    MusicDevice getMusicDevice(@Min(value = 1L, message = "Invalid musicDevice ID.") long id);

    MusicDevice save(MusicDevice musicDevice);

}
