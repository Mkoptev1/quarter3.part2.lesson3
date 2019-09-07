package com.geekbrains.services;

import com.geekbrains.entities.WareByClient;
import com.geekbrains.repositories.ClientsOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsOrderService {
    private ClientsOrderRepository clientsOrderRepository;

    @Autowired
    public void setClientRepository(ClientsOrderRepository clientsOrderRepository) {
        this.clientsOrderRepository = clientsOrderRepository;
    }

    public List<WareByClient> getClientsOrderList() {
        return clientsOrderRepository.getWareByClientList();
    }
}
