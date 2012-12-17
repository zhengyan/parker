package main.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Zhengyan
 * Date: 12-12-18
 * Time: 上午12:21
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManager extends SuperParkingBoy {
    public ArrayList<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>();
    public HashMap<ParkingLot, ParkingBoy> parkingLotVsBoy = new HashMap<ParkingLot, ParkingBoy>();

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoyList.add(parkingBoy);
    }

    public ParkingLot addParkingLot(int parkingSize, ParkingBoy parkingBoy) {
        ParkingLot parkingLot = new ParkingLot(parkingSize);
        parkingBoy.parkList.add(parkingLot);
        parkList.add(parkingLot);
        parkingBoy.setMaxSpaceNum();
        setMaxSpaceNum();
        parkingLotVsBoy.put(parkingLot, parkingBoy);
        return parkingLot;
    }

    public void setCarNumber(int n, ParkingLot parkingLot) {
        ParkingBoy parkingBoy = parkingLotVsBoy.get(parkingLot);
        for (int i = 0; i < n; i++) {
            Ticket ticket = new Ticket();
            Car car = new Car();
            parkingBoy.carList.put(ticket, car);
            carList.put(ticket, car);
            parkingLot.setCarNumber(parkingLot.getCarNumber() + 1);
            parkingBoy.carVsLot.put(ticket, parkingLot);
            carVsLot.put(ticket, parkingLot);
        }
        parkingBoy.calcCarNumber();
        calcCarNumber();
    }
}
