package com.emrecn.biletal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Column(name = "name")
    private String name;
    @Column(name="lastname")
    private String lastName;
    @Id
    @Column(name = "tc_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tcNo;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE , CascadeType.DETACH ,CascadeType.REFRESH  })
    @JoinColumn(name = "bus_number")
    private Bus bus;

    public Passenger(String name, String lastName, int tcNo) {
        this.name = name;
        this.lastName = lastName;
        this.tcNo = tcNo;
    }

    public Passenger(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public com.emrecn.biletal.entity.Bus getBus() {
        return bus;
    }

    public void setBus(com.emrecn.biletal.entity.Bus bus) {
        this.bus = bus;
    }
}
