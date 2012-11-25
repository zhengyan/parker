package Parking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagement {
    private int carNumber;
    private int maxSpaceNum;
    private ParkingBoy parkingBoy;
    private HashMap<Ticket, Car> carList = new HashMap<Ticket, Car>();

    public ParkingManagement(){

    }
    public ParkingManagement(ArrayList<ParkingLot> parkList) {
        for(int i = 0; i < parkList.size(); i++){
            maxSpaceNum = parkList.get(i).getParkSize();
        }
        parkingBoy = new ParkingBoy(parkList);
    }

    public void setMaxSpaceNum(int i) {
        maxSpaceNum = i;
    }

    public void setByParkList(ArrayList<ParkingLot> parkList){

    }

    public void setCarNumber(int i) {
        carNumber = i;
    }

    public int getFreeSpace() {
        return maxSpaceNum - carNumber;
    }

    public Ticket parkCar(Car car) {
        if(getFreeSpace() > 0){
            carNumber = carNumber + 1;
            Ticket ticket = parkingBoy.parking(car);
            carList.put(ticket, car);
            return ticket;
        } else{
            throw new FullParkingLot();
        }
    }

    public String takeCar(Ticket ticket) {
        if (carNumber > 0 && !carList.isEmpty()){
            carNumber = carNumber - 1;
            carList.remove(getCarByTID(ticket));
            return "OK";
        }else{
            throw new UnknownTID();
        }
    }

    public Car getCarByTID(Ticket ticket){
        return carList.get(ticket);
    }
}
