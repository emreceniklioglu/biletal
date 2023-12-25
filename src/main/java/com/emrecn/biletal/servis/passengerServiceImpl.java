package com.emrecn.biletal.servis;
import com.emrecn.biletal.entity.Bus;
import com.emrecn.biletal.repos.busRepository;
import com.emrecn.biletal.repos.passangerRepository;

import com.emrecn.biletal.entity.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class passengerServiceImpl implements passengerService{

    private passangerRepository passengerRepository;
    private busRepository busRepository;

    public passengerServiceImpl(passangerRepository passengerRepository,busRepository busRepository) {
        this.passengerRepository = passengerRepository;
        this.busRepository = busRepository;
    }


    @Override
    public void savePassenger(Passenger passenger,int id) {

        Optional<Bus> busOptinal = busRepository.findById((long) id);

        if (busOptinal.isPresent()) {
            Bus bus = busOptinal.get();
            if(bus.getCapacity()>=1){
                passenger.setBus(bus);
                passengerRepository.save(passenger);
                bus.addPassengers(passenger);
                busRepository.save(bus);
            }else {
                throw new IllegalArgumentException("Bus is at full capacity");
            }

        } else {
            throw new IllegalArgumentException("bus not found with id: " + id);
        }


    }

    @Override
    public Passenger findPassBytcNo(int tcNo) {
        Optional<Passenger> passOptinal = passengerRepository.findBytcNo(tcNo);
        Passenger passenger = new Passenger();
        if(passOptinal.isPresent()){
            passenger = passOptinal.get();

        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + tcNo);
        }

        return passenger;
    }

    @Override
    public void deleteThePassenger(Passenger passenger) {
        Bus thebus = passenger.getBus();
        thebus.incrementCapacity();
        busRepository.save(thebus);
        passengerRepository.delete(passenger);

    }

}
