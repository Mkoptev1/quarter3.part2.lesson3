package com.geekbrains.repositories;

import com.geekbrains.entities.WareByClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientsOrderRepository {
    private List<WareByClient> wareByClientList = new ArrayList<>();

    public List<WareByClient> getWareByClientList() {
        return wareByClientList;
    }
}