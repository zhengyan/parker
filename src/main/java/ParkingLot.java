package main.java;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLot {
    private int parkSize;
    private int carNumber;


    public ParkingLot(int parkSize) {
        this.parkSize = parkSize;
    }

    public int getParkSize() {
        return parkSize;
    }
    public int getFreeNumber(){
        return parkSize - carNumber;
    }

    public void setCarNumber(int carNumber){
        this.carNumber = carNumber;
    }

    public int getCarNumber(){
        return carNumber;
    }
}
