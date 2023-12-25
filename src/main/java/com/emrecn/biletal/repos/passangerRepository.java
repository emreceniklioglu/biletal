package com.emrecn.biletal.repos;

import com.emrecn.biletal.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface passangerRepository extends JpaRepository<Passenger,Integer> {

    Optional<Passenger> findBytcNo(int tc);

    void deleteBytcNo(int tc);
}
