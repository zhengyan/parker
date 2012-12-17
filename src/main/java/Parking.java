package main.java;

import java.util.HashMap;

/**
 * 作业1：停车场管理
 * User: 郑岩
 * Date: 12-11-11
 * Time: 下午3:17
 */
public class Parking {
    public int carNumber;
    public int maxSpaceNum;
    public HashMap<Ticket, Car> carList = new HashMap<Ticket, Car>();

    public int getMaxSpaceNum() {
        return maxSpaceNum;
    }

    public void setMaxSpaceNum(int n) {
        maxSpaceNum = n;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int n) {
        carNumber = n;
    }

    public int getFreeSpace() {
        return getMaxSpaceNum() - getCarNumber();
    }

    public Ticket parkCar(Car car) {
        if (getFreeSpace() > 0) {
            carNumber = carNumber + 1;
            Ticket ticket = new Ticket();
            carList.put(ticket, car);
            return ticket;
        } else {
            throw new FullParkingLot();
        }
    }

    public String takeCar(Ticket ticket) {
        if (carNumber > 0 && !carList.isEmpty() && carList.get(ticket) != null) {
            carNumber = carNumber - 1;
            carList.remove(ticket);
            return "OK";
        } else {
            throw new UnknownTID();
        }
    }
}
