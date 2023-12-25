package com.emrecn.biletal.servis;
import com.emrecn.biletal.entity.Passenger;
import com.emrecn.biletal.repos.*;

import com.emrecn.biletal.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class busServisImpl implements busService {

    private busRepository busRepository;
    @Autowired
    public busServisImpl(com.emrecn.biletal.repos.busRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public List<Bus> getAllbuses() {
        return busRepository.findAll();
    }

    @Override
    public void saveBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public Bus getbusById(int id) {
        Optional<Bus> result = busRepository.findById((long) id);
        Bus theBus = null;

        if (result.isPresent()) {
            theBus = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return theBus;

    }
    @Override
    public void deletebusById(Long id) {
            busRepository.deleteById(id);
    }
}
