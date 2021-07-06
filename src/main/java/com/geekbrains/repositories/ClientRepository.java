package com.geekbrains.repositories;

import com.geekbrains.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientRepository {
    private List<Client> clientList = new ArrayList<>();
    private EntManager entManager;



    @Autowired
    public void setEntManager(EntManager entManager) {
        this.entManager = entManager;
    }

    public Client getClientById(Long _id) {
        Client client = new Client();
        return client;
    }

   public List<Client> getClientList() {



        return clientList;
    }

    public Client saveClient(Client _client) {
        return _client;
    }
}