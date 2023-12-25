package com.emrecn.biletal.servis;

import com.emrecn.biletal.entity.Bus;
import com.emrecn.biletal.entity.Passenger;
import org.springframework.ui.Model;

import java.util.List;

public interface busService {

    List<Bus> getAllbuses();

    void saveBus(Bus bus);

    Bus getbusById(int id);

    void deletebusById(Long id);


}
