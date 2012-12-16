package test.java;

import junit.framework.Assert;
import main.java.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class test {

    @Test
    public void test_car_in_area_ok(){
        //setup
        ParkingManagement parkingManagement = new ParkingManagement();
        Car car = new Car();
        parkingManagement.setMaxSpaceNum(100);
        parkingManagement.setCarNumber(50);
        //test
        parkingManagement.parkCar(car);
        //assert
        Assert.assertEquals(49, parkingManagement.getFreeSpace());
    }

    @Test
    public void test_car_out_area_ok(){
        //setup
        ParkingManagement parkingManagement = new ParkingManagement();
        Car car = new Car();
        parkingManagement.setMaxSpaceNum(100);
        parkingManagement.setCarNumber(0);
        Ticket ticket;
        //test
        ticket = parkingManagement.parkCar(car);
        parkingManagement.takeCar(ticket);
        //assert
        Assert.assertEquals(100, parkingManagement.getFreeSpace());
    }

    @Test (expected = FullParkingLot.class)
    public void test_car_in_area_full(){
        //setup
        ParkingManagement parkingManagement = new ParkingManagement();
        Car car = new Car();
        parkingManagement.setMaxSpaceNum(100);
        parkingManagement.setCarNumber(100);
        //test
        parkingManagement.parkCar(car);
        //assert
        Assert.assertEquals(0, parkingManagement.getFreeSpace());
    }

    @Test (expected = UnknownTID.class)
    public void test_car_out_area_empty(){
        //setup
        ParkingManagement parking = new ParkingManagement();
        parking.setMaxSpaceNum(100);
        parking.setCarNumber(0);
        //test
        parking.takeCar(new Ticket());
        //assert
        Assert.assertEquals(100, parking.getFreeSpace());
    }

    //**************************************   1   **********************************************

    @Test
    public void test_parkingBoy_park_car_ok(){
        //setup
        Car car = new Car();
        ParkingManagement parkingManagement = new ParkingManagement();
        parkingManagement.addParkingLot(10);
        parkingManagement.addParkingLot(20);
        parkingManagement.setCarNumber(0);
        //test
        parkingManagement.parkCar(car);
        //assert
        Assert.assertEquals(29, parkingManagement.getFreeSpace());
    }

    @Test
    public void test_parkingBoy_take_car_ok(){
        //setup
        Car car = new Car();
        ParkingManagement parkingManagement = new ParkingManagement();
        parkingManagement.addParkingLot(10);
        parkingManagement.addParkingLot(20);
        parkingManagement.setCarNumber(0);
        Ticket ticket;
        //test
        ticket = parkingManagement.parkCar(car);
        parkingManagement.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingManagement.getFreeSpace());
    }

    @Test (expected = FullParkingLot.class)
    public void test_parkingBoy_park_car_error(){
        //setup
        Car car = new Car();
        ParkingManagement parkingManagement = new ParkingManagement();
        parkingManagement.addParkingLot(10);
        parkingManagement.addParkingLot(20);
        parkingManagement.setCarNumber(30);
        //test
        parkingManagement.parkCar(car);
        //assert
        Assert.assertEquals(30, parkingManagement.getFreeSpace());
    }

    @Test (expected = UnknownTID.class)
    public void test_parkingBoy_take_car_error(){
        //setup
        Car car = new Car();
        ParkingManagement parkingManagement = new ParkingManagement();
        parkingManagement.addParkingLot(10);
        parkingManagement.addParkingLot(20);
        parkingManagement.setCarNumber(0);
        Ticket ticket = new Ticket();
        //test
        parkingManagement.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingManagement.getFreeSpace());
    }

    //**************************************   2   **********************************************
    @Test
    public void test_smart_parkingBoy_park_car_ok(){
        //setup
        Car car = new Car();
        ParkingManagement parkingManagement = new ParkingManagement();
        parkingManagement.addParkingLot(10);
        parkingManagement.addParkingLot(20);
        parkingManagement.setCarNumber(0);
        //test
        parkingManagement.parkCar(car);
        //assert
        Assert.assertEquals(29, parkingManagement.getFreeSpace());
    }
    //**************************************   3   **********************************************
}
