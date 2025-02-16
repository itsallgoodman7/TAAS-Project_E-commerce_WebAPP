package com.taass.ecommerce.service;

import com.taass.ecommerce.model.OrderMusicDevice;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderMusicDeviceService {

    OrderMusicDevice create(@NotNull(message = "The musicDevices for order cannot be null.") @Valid OrderMusicDevice orderMusicDevice);
}
