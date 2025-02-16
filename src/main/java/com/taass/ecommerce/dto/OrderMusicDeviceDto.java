package com.taass.ecommerce.dto;

import com.taass.ecommerce.model.MusicDevice;

// DTO is an object that carries data between processes.
// When you're working with a remote interface, each call it is expensive.
// As a result you need to reduce the number of calls.
// The solution is to create a Data Transfer Object that can hold all the data for the call.

public class OrderMusicDeviceDto {

    private MusicDevice musicDevice;
    private Integer quantity;

    public MusicDevice getMusicDevice() {
        return musicDevice;
    }

    public void setMusicDevice(MusicDevice musicDevice) {
        this.musicDevice = musicDevice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
