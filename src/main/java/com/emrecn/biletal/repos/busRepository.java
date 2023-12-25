package com.emrecn.biletal.repos;

import com.emrecn.biletal.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface busRepository extends JpaRepository<Bus,Long> {
}
