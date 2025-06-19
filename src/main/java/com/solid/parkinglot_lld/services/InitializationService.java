package com.solid.parkinglot_lld.services;

import com.solid.parkinglot_lld.models.*;
import com.solid.parkinglot_lld.repositories.ParkingLotRepository;
import com.solid.parkinglot_lld.strategies.NearestSlotAllocation;

import java.util.ArrayList;

public class InitializationService {

    private final ParkingLotRepository parkingLotRepository;

    public InitializationService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot initializeParkingLot(){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setParkingLotStatus(Status.AVAILABLE);
        parkingLot.setParkingFloors(new ArrayList<>());
        parkingLot.setEntryGates(new ArrayList<>());
        parkingLot.setExitGates(new ArrayList<>());

        //create a gate
        Gate entryGate = new Gate(1, "1", GateType.ENTRY, GateStatus.OPERTIONAL,
                new Operator("ABC"));
        parkingLot.getEntryGates().add(entryGate);

        for(int i=0; i<3; i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setNumber(String.valueOf(i));
            parkingFloor.setParkingSlots(new ArrayList<>());
            parkingFloor.setParkingFloorStatus(Status.AVAILABLE);

            for(int j=0; j<10; j++){
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setId(j);
                parkingSlot.setNumber(String.valueOf((i*10)+j));
                if(j % 4 == 0){
                    parkingSlot.setVehicleType(VehicleType.TWO_WHEELER);
                }else if(j%4 == 1){
                    parkingSlot.setVehicleType(VehicleType.FOUR_WHEELER);
                }else if( j%4 == 2){
                    parkingSlot.setVehicleType(VehicleType.HEAVY_VEHICLE);
                }else{
                    parkingSlot.setVehicleType(VehicleType.ELECTRIC_VEHICLE);
                }
                parkingSlot.setParkingSlotStatus(Status.AVAILABLE);
                parkingFloor.getParkingSlots().add(parkingSlot);
            }
            parkingLot.getParkingFloors().add(parkingFloor);
        }
        parkingLot.setSlotAllocationTypeStrategy(new NearestSlotAllocation());
        return parkingLotRepository.save(parkingLot);
    }
}
