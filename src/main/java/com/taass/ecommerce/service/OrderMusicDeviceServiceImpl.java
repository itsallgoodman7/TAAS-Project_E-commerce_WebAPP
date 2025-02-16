package com.taass.ecommerce.service;

import com.taass.ecommerce.model.OrderMusicDevice;
import com.taass.ecommerce.repository.OrderMusicDeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderMusicDeviceServiceImpl implements OrderMusicDeviceService {

    private OrderMusicDeviceRepository orderMusicDeviceRepository;

    public OrderMusicDeviceServiceImpl(OrderMusicDeviceRepository orderMusicDeviceRepository) {
        this.orderMusicDeviceRepository = orderMusicDeviceRepository;
    }

    @Override
    public OrderMusicDevice create(OrderMusicDevice orderMusicDevice) {
        return this.orderMusicDeviceRepository.save(orderMusicDevice);
    }
}
