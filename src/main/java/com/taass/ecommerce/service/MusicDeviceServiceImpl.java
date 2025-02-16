package com.taass.ecommerce.service;

import com.taass.ecommerce.exception.ResourceNotFoundException;
import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import com.taass.ecommerce.repository.MusicDeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MusicDeviceServiceImpl implements MusicDeviceService {

    private MusicDeviceRepository musicDeviceRepository;

    public MusicDeviceServiceImpl(MusicDeviceRepository musicDeviceRepository) {
        this.musicDeviceRepository = musicDeviceRepository;
    }

    @Override
    public Iterable<MusicDevice> getAllMusicDevices() {
        return musicDeviceRepository.findAll();
    }

    @Override
    public Iterable<MusicDevice> findByNameContainingIgnoreCase(String name) {
        return musicDeviceRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteAllMusicDevices(){ musicDeviceRepository.deleteAll(); }

    @Override
    public void deleteMusicDeviceByID(long id) { musicDeviceRepository.deleteById(id);}

    @Override
    public Iterable<MusicDevice> findByCategory(MusicDeviceCategories category) {  return musicDeviceRepository.findByCategory(category);}

    @Override
    public Iterable<MusicDevice> findByRange(double p1, double p2) {  return musicDeviceRepository.findByRange(p1,p2);}

    @Override
    public Iterable<MusicDevice> findByCatRange(double p1, double p2, MusicDeviceCategories category) {  return musicDeviceRepository.findByCatRange(p1,p2, category);}

    @Override
    public MusicDevice getMusicDevice(long id) {
        return musicDeviceRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("MusicDevice not found"));
    }

    @Override
    public MusicDevice save(MusicDevice musicDevice) {
        return musicDeviceRepository.save(musicDevice);
    }
}
