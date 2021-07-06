package com.geekbrains.entities;

import javax.persistence.*;

@Entity
@Table(name = "client_order")
public class ClientsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_order_id")
    private Long client_order_id;

    @Column(name = "client_id")
    private Long client_id;

    @Column(name = "ware_id")
    private Long ware_id;

    @Column(name = "ware_cost")
    private Long ware_cost;

    public Long getClient_order_id() {
        return client_order_id;
    }

    public void setClient_order_id(Long client_order_id) {
        this.client_order_id = client_order_id;
    }

    public ClientsOrder() {
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getWare_id() {
        return ware_id;
    }

    public void setWare_id(Long ware_id) {
        this.ware_id = ware_id;
    }

    public Long getWare_cost() {
        return ware_cost;
    }

    public void setWare_cost(Long ware_cost) {
        this.ware_cost = ware_cost;
    }

    @Override
    public String toString() {
        return "ClientsOrder{" +
                "client_order_id=" + client_order_id +
                ", client_id=" + client_id +
                ", ware_id=" + ware_id +
                ", ware_cost=" + ware_cost +
                '}';
    }
}