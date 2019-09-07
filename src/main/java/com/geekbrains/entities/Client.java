package com.geekbrains.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long client_id;

    @Column(name = "client_name")
    private String client_name;
/*
    @OneToMany(mappedBy = "ware" )
    private List<Ware> wareList;
*/
    public Client() {
    }

    public Client(String client_name) {
        this.client_name = client_name;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", client_name='" + client_name + '\'' +
                '}';
    }
}
