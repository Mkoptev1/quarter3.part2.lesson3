package com.geekbrains.repositories;

import com.geekbrains.entities.Ware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WareRepository {
    private List<Ware> wareList = new ArrayList<>();

    public Ware getWareById(Long _id) {
        Ware ware = new Ware();
        return ware;
    }

    public List<Ware> getWareList() {
        return wareList;
    }

    public Ware saveWare(Ware _ware) {
        int arrayId;

        arrayId = wareList.size();
        _ware.setWare_id((long) arrayId);
        wareList.add(arrayId,_ware);

        return _ware;
    }
}