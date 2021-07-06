package com.geekbrains.services;

import com.geekbrains.entities.Client;
import com.geekbrains.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientList() {
        return clientRepository.getClientList();
    }

    public Client saveClient(Client _client) {
        return clientRepository.saveClient(_client);
    }

    public Client getClientById(Long _id) {
        return clientRepository.getClientById(_id);
    }
}
