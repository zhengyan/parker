package park;

import java.util.HashMap;

/**
 * Final Mission：ParkingManager
 * User: 郑岩
 * Date: 12-11-25
 * Time: 下午5:01
 */
public class ParkingManager extends SuperParkingBoy {
    public HashMap<String, ParkingBoy> parkingBoyList = new HashMap<String, ParkingBoy>();
    public HashMap<ParkingLot, ParkingBoy> parkingLotVsBoy = new HashMap<ParkingLot, ParkingBoy>();

    public void addParkingBoy(String parkingBoyId, ParkingBoy parkingBoy) {
        parkingBoyList.put(parkingBoyId, parkingBoy);
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
