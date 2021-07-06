package com.geekbrains.repositories;

import com.geekbrains.entities.ClientWareLink;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientsOrderRepository {
    private List<ClientWareLink> clientWareLinkList = new ArrayList<>();

    public List<ClientWareLink> getClientWareLinkList() {
        return clientWareLinkList;
    }
}