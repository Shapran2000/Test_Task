package com.aircompanies.task.repository;


import com.aircompanies.task.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
   @Query(value = "select * from flights f\n" +
           "inner join air_companies a\n" +
           "on f.air_company_id=a.id\n" +
           "where f.status=?1\n" +
           "and a.name=?2",nativeQuery = true)
   List<Flight> findByFlightStatus(String status, String name);


   @Query(value = "select * from flights f \n" +
           "where f.status='ACTIVE'\n" +
           "and f.created_at <= NOW() - INTERVAL 24 hour",nativeQuery = true)
   List<Flight> findAllInActive();

}
