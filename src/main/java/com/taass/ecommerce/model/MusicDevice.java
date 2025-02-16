package com.taass.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "musicDevice")
public class MusicDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "MusicDevice name is required.")
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private MusicDeviceCategories category;

    @Column(name = "price")
    private Double price;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    public MusicDevice(Long id, @NotNull(message = "MusicDevice name is required.") String name, Double price, MusicDeviceCategories category, String pictureUrl, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.category = category;
        this.description = description;
    }

    public MusicDevice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public MusicDeviceCategories getCategory() { return category;}

    public void setCategory(MusicDeviceCategories category) {this.category = category;}

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
