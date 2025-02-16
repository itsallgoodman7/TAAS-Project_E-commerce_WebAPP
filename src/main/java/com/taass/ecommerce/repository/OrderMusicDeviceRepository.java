package com.taass.ecommerce.repository;

import com.taass.ecommerce.model.OrderMusicDevice;
import com.taass.ecommerce.model.OrderMusicDevicePK;
import org.springframework.data.repository.CrudRepository;
// T - the domain type the repository manages
//ID - the type of the id of the entity the repository manages
public interface OrderMusicDeviceRepository extends CrudRepository<OrderMusicDevice, OrderMusicDevicePK> {
}
