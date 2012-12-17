package test.java;

import junit.framework.Assert;
import main.java.*;
import org.junit.Test;

/**
 * 作业2：ParkingBoy
 * User: 郑岩
 * Date: 12-11-11
 * Time: 下午3:32
 */
public class test_ParkingBoy {
    //**************************************   第二次作业   **********************************************

    /**
     * 任务分解1
     * 当存在N个停车场，停车场有空车位时；停车；空车位-1，停车成功。
     */
    @Test
    public void test_parkingBoy_park_car_ok(){
        //setup
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(10);
        parkingBoy.addParkingLot(20);
        parkingBoy.setCarNumber(0);
        //test_Parking
        parkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(29, parkingBoy.getFreeSpace());
    }

    /**
     * 任务分解2
     * 当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_parkingBoy_take_car_ok(){
        //setup
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(10);
        parkingBoy.addParkingLot(20);
        parkingBoy.setCarNumber(0);
        Ticket ticket;
        //test_Parking
        ticket = parkingBoy.parkCar(car);
        parkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingBoy.getFreeSpace());
    }

    /**
     * 任务分解3
     * 当存在N个停车场，停车场无空车位时；停车；空车位不变，停车失败。
     */
    @Test (expected = FullParkingLot.class)
    public void test_parkingBoy_park_car_error(){
        //setup
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(10);
        parkingBoy.addParkingLot(20);
        parkingBoy.setCarNumber(30);
        //test_Parking
        parkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(30, parkingBoy.getFreeSpace());
    }

    /**
     *  任务分解4
     *  当存在N个停车场，取车票不存在时；拿票取车；空车位不变，取车失败。
     */
    @Test (expected = UnknownTID.class)
    public void test_parkingBoy_take_car_error(){
        //setup
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(10);
        parkingBoy.addParkingLot(20);
        parkingBoy.setCarNumber(0);
        Ticket ticket = new Ticket();
        //test_Parking
        parkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingBoy.getFreeSpace());
    }
}
