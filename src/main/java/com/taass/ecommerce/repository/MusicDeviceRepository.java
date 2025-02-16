package com.taass.ecommerce.repository;

import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicDeviceRepository extends CrudRepository<MusicDevice, Long> {

    @Query("select p from MusicDevice p where p.category = :category")
    List<MusicDevice> findByCategory(@Param("category") MusicDeviceCategories category);

    @Query("select p from MusicDevice p where p.price > :p1 AND p.price < :p2")
    List<MusicDevice> findByRange(@Param("p1") double p1, @Param("p2") double p2);

    @Query("select p from MusicDevice p where p.price > :p1 AND p.price < :p2 AND p.category = :category")
    List<MusicDevice> findByCatRange(@Param("p1") double p1, @Param("p2") double p2, @Param("category") MusicDeviceCategories category);

    List<MusicDevice> findByNameContainingIgnoreCase(String name);
}
