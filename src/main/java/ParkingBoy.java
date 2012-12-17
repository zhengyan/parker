package main.java;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 作业2：ParkingBoy
 * User: 郑岩
 * Date: 12-11-11
 * Time: 下午3:32
 */
public class ParkingBoy extends Parking {
    public ArrayList<ParkingLot> parkList = new ArrayList<ParkingLot>();
    public HashMap<Ticket, ParkingLot> carVsLot = new HashMap<Ticket, ParkingLot>();

    public void setMaxSpaceNum() {
        maxSpaceNum = 0;
        for (ParkingLot aParkList : parkList) {
            maxSpaceNum += aParkList.getParkSize();
        }
    }

    public void setCarNumber(int n, ParkingLot parkingLot) {
        for (int i = 0; i < n; i++) {
            Ticket ticket = new Ticket();
            Car car = new Car();
            carList.put(ticket, car);
            carVsLot.put(ticket, parkingLot);
            parkingLot.setCarNumber(parkingLot.getCarNumber() + 1);
        }
        calcCarNumber();
    }

    public void calcCarNumber(){
        carNumber = 0;
        for (ParkingLot aParkList : parkList) {
            carNumber += aParkList.getCarNumber();
        }
    }

    public ParkingLot addParkingLot(int parkingSize) {
        ParkingLot parkingLot = new ParkingLot(parkingSize);
        parkList.add(parkingLot);
        setMaxSpaceNum();
        return parkingLot;
    }
}
