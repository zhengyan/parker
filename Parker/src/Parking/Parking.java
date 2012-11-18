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
public class Parking {
    public int carNumber;
    public int freeSpace;
    private HashMap<String, Car> carList = new HashMap<String, Car>();


    public void setFreeSpace(int i) {
        freeSpace = i;
    }

    public void setCarNumber(int i) {
        carNumber = i;
    }

    public int getAreaNumber() {
        return freeSpace - carNumber;
    }

    public String add(Car car) {
        if(getAreaNumber() > 0){
            String tid = "A0000" + carNumber;
            carNumber = carNumber + 1;
            carList.put(tid, car);
            return tid;
        }
        throw new FullParkingArea();
    }

    public String minus(String tid) {
        if (carNumber > 0 && !carList.isEmpty()){
            carNumber = carNumber - 1;
            carList.remove(getCarByTID(tid));
            return "OK";
        }
        throw new UnknownTID();
    }

    public Car getCarByTID(String tid){
        return carList.get(tid);
    }
}
