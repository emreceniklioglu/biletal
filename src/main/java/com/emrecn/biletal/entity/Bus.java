package com.emrecn.biletal.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_time")
    private String departureTime;
    @Column(name="arrival_time")
    private String arrivalTime;
    @Column(name = "destination")
    private String destination;
    @Column(name= "firma")
    private String firma;
    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "bus" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Passenger> passengers;

    public Bus(Long id, String departureTime, String arrivalTime, String destination, String firma,int capacity) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.destination = destination;
        this.firma = firma;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPassengers(Passenger passenger){
        if (passengers == null) {
            passengers = new ArrayList<>();
        }

        if (this.capacity > 0) {
            passengers.add(passenger);
            this.capacity--;
        } else {
            throw new IllegalStateException("Bus is already full.");
        }
    }

    public void incrementCapacity(){
        int cap = getCapacity();
        setCapacity(cap+1);
    }
    public Bus(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
