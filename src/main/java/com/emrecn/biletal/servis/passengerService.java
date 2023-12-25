package com.emrecn.biletal.servis;

import com.emrecn.biletal.entity.Bus;
import com.emrecn.biletal.entity.Passenger;

import java.util.List;

public interface passengerService {
    void savePassenger(Passenger passenger,int id);
    Passenger findPassBytcNo(int tc);
    void deleteThePassenger(Passenger passenger);
}
