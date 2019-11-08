package com.clay4seed.demo_.GraphQL.service;

import com.clay4seed.demo_.GraphQL.model.Vehicle;
import com.clay4seed.demo_.GraphQL.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kneotrino
 * @date 08/11/19
 */

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  public VehicleService(final VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Transactional
  public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
    final Vehicle vehicle = new Vehicle();
    vehicle.setType(type);
    vehicle.setModelCode(modelCode);
    vehicle.setBrandName(brandName);
//    vehicle.setLaunchDate(LocalDate.parse(launchDate));
    return this.vehicleRepository.save(vehicle);
  }

  @Transactional(readOnly = true)
  public List<Vehicle> getAllVehicles(final int count) {
    return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public Optional<Vehicle> getVehicle(final int id) {
    return this.vehicleRepository.findById(id);
  }
}
