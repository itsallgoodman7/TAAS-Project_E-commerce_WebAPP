package com.taass.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class OrderMusicDevice {

    @EmbeddedId
    @JsonIgnore
    private OrderMusicDevicePK pk;

    @Column(nullable = false) private Integer quantity;

    public OrderMusicDevice() {
        super();
    }

    public OrderMusicDevice(Order order, MusicDevice musicDevice, Integer quantity) {
        pk = new OrderMusicDevicePK();
        pk.setOrder(order);
        pk.setMusicDevice(musicDevice);
        this.quantity = quantity;
    }

    @Transient
    public MusicDevice getMusicDevice() {
        return this.pk.getMusicDevice();
    }

    @Transient
    public Double getTotalPrice() {
        return getMusicDevice().getPrice() * getQuantity();
    }

    public OrderMusicDevicePK getPk() {
        return pk;
    }

    public void setPk(OrderMusicDevicePK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderMusicDevice other = (OrderMusicDevice) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}
