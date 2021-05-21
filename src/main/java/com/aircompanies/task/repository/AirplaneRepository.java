package com.aircompanies.task.repository;


import com.aircompanies.task.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Long> {
    Airplane findAirplaneByName(String name);
}
