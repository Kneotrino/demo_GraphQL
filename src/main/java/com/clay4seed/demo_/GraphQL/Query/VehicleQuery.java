package com.clay4seed.demo_.GraphQL.Query;

import com.clay4seed.demo_.GraphQL.model.Vehicle;
import com.clay4seed.demo_.GraphQL.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Kneotrino
 * @date 08/11/19
 */

@Component
public class VehicleQuery implements GraphQLQueryResolver {

  @Autowired
  private VehicleService vehicleService;

  public List<Vehicle> getVehicles(final int count) {
    return this.vehicleService.getAllVehicles(count);
  }

  public Optional<Vehicle> getVehicle(final int id) {
    return this.vehicleService.getVehicle(id);
  }
}