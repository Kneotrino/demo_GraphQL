package com.clay4seed.demo_.GraphQL.repository;

import com.clay4seed.demo_.GraphQL.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kneotrino
 * @date 08/11/19
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


}
