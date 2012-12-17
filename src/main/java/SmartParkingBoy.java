package main.java;

/**
 * 作业3：SmartParkingBoy
 * User: 郑岩
 * Date: 12-12-02
 * Time: 下午4:50
 */
public class SmartParkingBoy extends ParkingBoy {

    public Ticket parkCar(Car car) {
        if (getFreeSpace() > 0) {
            Ticket ticket = new Ticket();
            ParkingLot parkingLot = getBetterParkingLot();
            carList.put(ticket, car);
            carVsLot.put(ticket, parkingLot);
            parkingLot.setCarNumber(parkingLot.getCarNumber() + 1);
            calcCarNumber();
            return ticket;
        } else {
            throw new FullParkingLot();
        }
    }

    public String takeCar(Ticket ticket) {
        ParkingLot parkingLot = carVsLot.get(ticket);
        if (carNumber > 0 && !carList.isEmpty() && parkingLot != null) {
            carList.remove(ticket);
            carVsLot.remove(ticket);
            parkingLot.setCarNumber(parkingLot.getCarNumber() - 1);
            calcCarNumber();
            return "OK";
        } else {
            throw new UnknownTID();
        }
    }

    public ParkingLot getBetterParkingLot() {
        ParkingLot parkingLot = null;
        for (int i = 0; i < parkList.size() - 1; i++) {
            if (parkList.get(i).getFreeNumber() >= parkList.get(i + 1).getFreeNumber()) {
                parkingLot = parkList.get(i);
            } else {
                parkingLot = parkList.get(i + 1);
            }
        }
        return parkingLot;
    }
}
