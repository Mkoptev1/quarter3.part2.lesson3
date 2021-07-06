package com.geekbrains.services;

import com.geekbrains.entities.Ware;
import com.geekbrains.repositories.WareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareService {
    private WareRepository wareRepository;

    @Autowired
    public void setWareRepository(WareRepository _wareRepository) {
        this.wareRepository = _wareRepository;
    }

    public Ware getWareById(Long id) {
        return wareRepository.getWareById(id);
    }

    public Ware saveWare(Ware _ware) {
        return wareRepository.saveWare(_ware);
    }

    public List<Ware> getWareList() {
        return wareRepository.getWareList();
    }
}
