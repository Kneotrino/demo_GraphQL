package com.clay4seed.demo_.GraphQL.Query;

import com.clay4seed.demo_.GraphQL.model.Vehicle;
import com.clay4seed.demo_.GraphQL.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Kneotrino
 * @date 08/11/19
 */
@Component
public class VehicleMutation implements GraphQLMutationResolver {

  @Autowired
  private VehicleService vehicleService;

  public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
    return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
  }
}