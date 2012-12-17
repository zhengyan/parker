package test.java;

import junit.framework.Assert;
import main.java.*;
import org.junit.Before;
import org.junit.Test;

/**
 * 最终作业：ParkingManager
 * User: 郑岩
 * Date: 12-11-25
 * Time: 下午5:01
 */
public class test_ParkingManager {
    //**************************************   最终作业之一   **********************************************
    ParkingManager parkingManager;
    ParkingBoy  parkingBoy;
    SmartParkingBoy smartParkingBoy;
    SuperParkingBoy superParkingBoy;
    ParkingLot parkingLot1;
    ParkingLot parkingLot2;
    ParkingLot parkingLot3;
    ParkingLot parkingLot4;
    ParkingLot parkingLot5;
    ParkingLot parkingLot6;
    @Before
    public void init(){
        parkingManager = new ParkingManager();
        parkingBoy = new ParkingBoy();
        smartParkingBoy = new SmartParkingBoy();
        superParkingBoy = new SuperParkingBoy();
        parkingManager.addParkingBoy(parkingBoy);
        parkingManager.addParkingBoy(smartParkingBoy);
        parkingManager.addParkingBoy(superParkingBoy);

        parkingLot1 = parkingManager.addParkingLot(10, parkingBoy);
        parkingLot2 = parkingManager.addParkingLot(20, smartParkingBoy);
        parkingLot3 = parkingManager.addParkingLot(30, superParkingBoy);
        parkingLot4 = parkingManager.addParkingLot(40, parkingBoy);
        parkingLot5 = parkingManager.addParkingLot(50, smartParkingBoy);
        parkingLot6 = parkingManager.addParkingLot(60, superParkingBoy);

        parkingLot1.setParkId(1);
        parkingLot2.setParkId(2);
        parkingLot3.setParkId(3);
        parkingLot4.setParkId(4);
        parkingLot5.setParkId(5);
        parkingLot6.setParkId(6);
    }
    /**
     * 任务分解1
     * 当存在N个停车场，整个停车场有空车位时；ParkingManager停车；选择全场空置率最高的停车场，空车位-1，停车成功。
     */
    @Test
         public void test_parking_manager_self_park_car_ok(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        //test_Parking
        parkingManager.parkCar(car);
        //assert
        Assert.assertEquals(149, parkingManager.getFreeSpace());
        Assert.assertEquals(parkingLot6.getParkSize() - 10 - 1,parkingLot6.getFreeNumber());
    }

    /**
     * 任务分解2
     * 当存在N个停车场，ParkingBoy管辖范围内停车场有空车位时；ParkingBoy停车；选择自己管辖的停车场，空车位-1，停车成功。
     */
    @Test
    public void test_parking_manager_boy_park_car_ok(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        //test_Parking
        superParkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(69, superParkingBoy.getFreeSpace());
        Assert.assertEquals(parkingLot3.getParkSize() - 10,parkingLot3.getFreeNumber());
        Assert.assertEquals(parkingLot6.getParkSize() - 10 - 1,parkingLot6.getFreeNumber());
    }

    /**
     * 任务分解3
     * 当存在N个停车场，整个停车场有车时；ParkingManager拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_parking_manager_self_take_car_ok(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        Ticket ticket;
        //test_Parking
        ticket = parkingManager.parkCar(car);
        parkingManager.takeCar(ticket);
        //assert
        Assert.assertEquals(150, parkingManager.getFreeSpace());
        Assert.assertEquals(parkingLot6.getParkSize() - 10,parkingLot6.getFreeNumber());
    }

    /**
     * 任务分解4
     * 当存在N个停车场，ParkingBoy管辖范围内停车场有车时；ParkingBoy拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_parking_manager_boy_take_car_ok(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        Ticket ticket;
        //test_Parking
        ticket = parkingBoy.parkCar(car);
        parkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingBoy.getFreeSpace());
        Assert.assertEquals(parkingLot1.getParkSize() - 10,parkingLot1.getFreeNumber());
        Assert.assertEquals(parkingLot4.getParkSize() - 10,parkingLot4.getFreeNumber());
    }

    /**
     * 任务分解5
     * 当存在N个停车场，整个停车场无空车位时；ParkingManager停车；空车位不变，停车失败。
     */
    @Test (expected = FullParkingLot.class)
    public void  test_parking_manager_self_park_car_error(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(20, parkingLot2);
        parkingManager.setCarNumber(30, parkingLot3);
        parkingManager.setCarNumber(40, parkingLot4);
        parkingManager.setCarNumber(50, parkingLot5);
        parkingManager.setCarNumber(60, parkingLot6);
        //test_Parking
        parkingManager.parkCar(car);
        //assert
        Assert.assertEquals(0, parkingManager.getFreeSpace());
    }

    /**
     * 任务分解6
     * 当存在N个停车场，ParkingBoy管辖范围内停车场无空车位时；ParkingBoy停车；空车位不变，停车失败。
     */
    @Test (expected = FullParkingLot.class)
    public void  test_parking_manager_boy_park_car_error(){
        //setup
        Car car = new Car();
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(20, parkingLot2);
        parkingManager.setCarNumber(30, parkingLot3);
        parkingManager.setCarNumber(40, parkingLot4);
        parkingManager.setCarNumber(50, parkingLot5);
        parkingManager.setCarNumber(60, parkingLot6);
        //test_Parking
        parkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(0, parkingBoy.getFreeSpace());
    }

    /**
     *  任务分解7
     *  当存在N个停车场，取车票在整个停车场不存在时；ParkingManage拿票取车；空车位不变，取车失败。
     */
    @Test (expected = UnknownTID.class)
    public void test_parking_manager_self_take_car_error(){
        //setup
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        Ticket ticket = new Ticket();
        //test_Parking
        parkingManager.takeCar(ticket);
        //assert
        Assert.assertEquals(150, parkingManager.getFreeSpace());
    }

    /**
     *  任务分解8
     *  当存在N个停车场，取车票在ParkingBoy管辖范围内不存在时；ParkingBoy拿票取车；空车位不变，取车失败。
     */
    @Test (expected = UnknownTID.class)
    public void test_parking_manager_boy_take_car_error(){
        //setup
        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);
        Ticket ticket = new Ticket();
        //test_Parking
        parkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, parkingBoy.getFreeSpace());
    }
}
