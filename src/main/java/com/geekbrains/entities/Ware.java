package com.geekbrains.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ware")
public class Ware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ware_id")
    private Long ware_id;

    @Column(name = "ware_name")
    private String ware_name;

    @Column(name = "ware_cost")
    private Long ware_cost;

/*
    @OneToMany(mappedBy = "ware" )
    private List<Ware> wareList;
*/

    public Ware() {
    }

    public Long getWare_id() {
        return ware_id;
    }

    public void setWare_id(Long ware_id) {
        this.ware_id = ware_id;
    }

    public String getWare_name() {
        return ware_name;
    }

    public void setWare_name(String ware_name) {
        this.ware_name = ware_name;
    }

    public Long getWare_cost() {
        return ware_cost;
    }

    public void setWare_cost(Long ware_cost) {
        this.ware_cost = ware_cost;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "ware_id=" + ware_id +
                ", ware_name='" + ware_name + '\'' +
                ", ware_cost=" + ware_cost +
                '}';
    }
}
