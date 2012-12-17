package test.java;

import junit.framework.Assert;
import main.java.*;
import org.junit.Test;

/**
 * 作业3：SmartParkingBoy
 * User: 郑岩
 * Date: 12-12-02
 * Time: 下午4:50
 */
public class test_SmartParkingBoy {
    //**************************************   第三次作业   **********************************************

    /**
     * 任务分解1
     * 当存在N个停车场，停车场有空车位时；停车；选择空车位最多的停车场，空车位-1，停车成功。
     */
    @Test
    public void test_smart_parkingBoy_park_car_ok(){
        //setup
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot1= smartParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= smartParkingBoy.addParkingLot(20);
        smartParkingBoy.setCarNumber(5, parkingLot1);
        smartParkingBoy.setCarNumber(10, parkingLot2);

        //test_Parking
        smartParkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(14, smartParkingBoy.getFreeSpace());
        Assert.assertEquals(5,parkingLot1.getFreeNumber());
        Assert.assertEquals(9,parkingLot2.getFreeNumber());
    }

    /**
     * 任务分解2
     * 当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_smart_parkingBoy_take_car_ok(){
        //setup
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot1= smartParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= smartParkingBoy.addParkingLot(20);
        smartParkingBoy.setCarNumber(0, parkingLot1);
        smartParkingBoy.setCarNumber(0, parkingLot2);
        Ticket ticket;
        //test_Parking
        ticket = smartParkingBoy.parkCar(car);
        smartParkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, smartParkingBoy.getFreeSpace());
        Assert.assertEquals(10,parkingLot1.getFreeNumber());
        Assert.assertEquals(20,parkingLot2.getFreeNumber());
    }

    /**
     * 任务分解3
     * 当存在N个停车场，停车场无空车位时；停车；空车位不变，停车失败。
     */
    @Test (expected = FullParkingLot.class)
    public void test_smart_parkingBoy_park_car_error(){
        //setup
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot1= smartParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= smartParkingBoy.addParkingLot(20);
        smartParkingBoy.setCarNumber(10, parkingLot1);
        smartParkingBoy.setCarNumber(20, parkingLot2);

        //test_Parking
        smartParkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(0, smartParkingBoy.getFreeSpace());
        Assert.assertEquals(0,parkingLot1.getFreeNumber());
        Assert.assertEquals(0,parkingLot2.getFreeNumber());
    }

    /**
     *  任务分解4
     *  当存在N个停车场，取车票不存在时；拿票取车；空车位不变，取车失败。
     */
    @Test (expected = UnknownTID.class)
    public void test_smart_parkingBoy_take_car_error(){
        //setup
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLot1= smartParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= smartParkingBoy.addParkingLot(20);
        smartParkingBoy.setCarNumber(0, parkingLot1);
        smartParkingBoy.setCarNumber(0, parkingLot2);
        Ticket ticket = new Ticket();
        //test_Parking
        smartParkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, smartParkingBoy.getFreeSpace());
        Assert.assertEquals(10,parkingLot1.getFreeNumber());
        Assert.assertEquals(20,parkingLot2.getFreeNumber());
    }
}
