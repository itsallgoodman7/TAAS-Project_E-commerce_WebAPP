package com.taass.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderMusicDevicePK implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "musicDevice_id")
    private MusicDevice musicDevice;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MusicDevice getMusicDevice() {
        return musicDevice;
    }

    public void setMusicDevice(MusicDevice musicDevice) {
        this.musicDevice = musicDevice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((order.getId() == null)
          ? 0
          : order
            .getId()
            .hashCode());
        result = prime * result + ((musicDevice.getId() == null)
          ? 0
          : musicDevice
            .getId()
            .hashCode());

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
        OrderMusicDevicePK other = (OrderMusicDevicePK) obj;
        if (order == null) {
            if (other.order != null) {
                return false;
            }
        } else if (!order.equals(other.order)) {
            return false;
        }

        if (musicDevice == null) {
            if (other.musicDevice != null) {
                return false;
            }
        } else if (!musicDevice.equals(other.musicDevice)) {
            return false;
        }

        return true;
    }
}
