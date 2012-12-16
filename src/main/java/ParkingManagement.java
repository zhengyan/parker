package main.java;

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
    private HashMap<Ticket, Car> carList = new HashMap<Ticket, Car>();
    private HashMap<Ticket, ParkingLot> carVsLot = new HashMap<Ticket, ParkingLot>();
    private ArrayList<ParkingLot> parkList = new ArrayList<ParkingLot>();

    public ParkingManagement(){
        setMaxSpaceNum();
    }

    public void setMaxSpaceNum(int i) {
        maxSpaceNum = i;
    }

    public void setCarNumber(int i) {
        carNumber = i;
    }

    public int getFreeSpace() {
        return maxSpaceNum - carNumber;
    }

    public void setMaxSpaceNum(){
        maxSpaceNum = 0;
        for(int i = 0; i < parkList.size(); i++){
            maxSpaceNum += parkList.get(i).getParkSize();
        }
    }

    public void addParkingLot(int maxParkingSize){
        ParkingLot parkingLot = new ParkingLot(maxParkingSize);
        parkList.add(parkingLot);
        setMaxSpaceNum();
    }

    public Ticket parkCar(Car car) {
        if(getFreeSpace() > 0){
            carNumber = carNumber + 1;
            Ticket ticket = new Ticket();
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

    public ParkingLot getBetterParkingLot(){
        ParkingLot parkingLot = null;
        for(int i=0; i< parkList.size() - 1; i++){
            if(parkList.get(i).getFreeNumber() > parkList.get(i + 1).getFreeNumber()){
                parkingLot = parkList.get(i);
            }
        }
        return parkingLot;
    }
}
