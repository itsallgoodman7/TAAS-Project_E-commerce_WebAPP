package com.taass.ecommerce.controller;

import com.taass.ecommerce.dto.OrderMusicDeviceDto;
import com.taass.ecommerce.exception.ResourceNotFoundException;
import com.taass.ecommerce.model.Order;
import com.taass.ecommerce.model.OrderMusicDevice;
import com.taass.ecommerce.model.OrderStatus;
import com.taass.ecommerce.service.OrderMusicDeviceService;
import com.taass.ecommerce.service.OrderService;
import com.taass.ecommerce.service.MusicDeviceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrderController {

    MusicDeviceService musicDeviceService;
    OrderService orderService;
    OrderMusicDeviceService orderMusicDeviceService;

    public OrderController(MusicDeviceService musicDeviceService, OrderService orderService, OrderMusicDeviceService orderMusicDeviceService) {
        this.musicDeviceService = musicDeviceService;
        this.orderService = orderService;
        this.orderMusicDeviceService = orderMusicDeviceService;
    }

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderMusicDeviceDto> formDtos = form.getMusicDeviceOrders();
        validateMusicDevicesExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);
        //creation of the 1st table in the db: ORDER(id, date_created, status="PAID")

        List<OrderMusicDevice> orderMusicDevices = new ArrayList<>();
        for (OrderMusicDeviceDto dto : formDtos) {
            orderMusicDevices.add(orderMusicDeviceService.create(new OrderMusicDevice(order, musicDeviceService.getMusicDevice(dto
              .getMusicDevice()
              .getId()), dto.getQuantity())));
        }

        order.setOrderMusicDevices(orderMusicDevices);
        //assign to ORDER the List<OrderMusicDevice> associated to it

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateMusicDevicesExistence(List<OrderMusicDeviceDto> orderMusicDevices) {
        List<OrderMusicDeviceDto> list = orderMusicDevices
          .stream()
          .filter(op -> Objects.isNull(musicDeviceService.getMusicDevice(op
            .getMusicDevice()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("MusicDevice not found");
        }
    }

    public static class OrderForm {

        private List<OrderMusicDeviceDto> musicDeviceOrders;

        public List<OrderMusicDeviceDto> getMusicDeviceOrders() {
            return musicDeviceOrders;
        }

        public void setMusicDeviceOrders(List<OrderMusicDeviceDto> musicDeviceOrders) {
            this.musicDeviceOrders = musicDeviceOrders;
        }
    }
}
