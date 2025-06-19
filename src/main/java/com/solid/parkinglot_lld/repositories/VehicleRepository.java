package com.solid.parkinglot_lld.repositories;

import com.solid.parkinglot_lld.models.Vehicle;
import com.solid.parkinglot_lld.models.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    Map<String, Vehicle> vehicles;
    private static int counter;

    public VehicleRepository() {
        vehicles = new HashMap<>();
        counter++;
    }
    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        return Optional.ofNullable(vehicles.get(licensePlate));
    }
    public Vehicle save(VehicleType vehicleType, String Licenseplate) {
        Vehicle vehicle = new Vehicle(vehicleType, Licenseplate);
        vehicle.setId(counter++);
        vehicles.put(Licenseplate, vehicle);
        return vehicle;

    }
}
