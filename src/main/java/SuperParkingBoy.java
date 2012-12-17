package main.java;


/**
 * 作业4：SuperParkingBoy
 * User: 郑岩
 * Date: 12-12-17
 * Time: 下午10:56
 */
public class SuperParkingBoy extends SmartParkingBoy {
    public ParkingLot getBetterParkingLot() {
        ParkingLot parkingLot = null;
        for (int i = 0; i < parkList.size() - 1; i++) {
            if (parkList.get(i).getFreeNumber() / parkList.get(i).getParkSize() >= parkList.get(i + 1).getFreeNumber() / parkList.get(i).getParkSize()) {
                parkingLot = parkList.get(i);
            }else{
                parkingLot = parkList.get(i + 1);
            }
        }
        return parkingLot;
    }
}
