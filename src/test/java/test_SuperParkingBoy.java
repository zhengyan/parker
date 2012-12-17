package test.java;

import junit.framework.Assert;
import main.java.*;
import org.junit.Test;

/**
 * 作业4：SuperParkingBoy
 * User: 郑岩
 * Date: 12-12-17
 * Time: 下午10:56
 */
public class test_SuperParkingBoy {
    //**************************************   第四次作业   **********************************************

    /**
     * 任务分解1
     * 当存在N个停车场，停车场有空车位时；停车；选择空置率最高的停车场，空车位-1，停车成功。
     */
    @Test
    public void test_super_parkingBoy_park_car_ok(){
        //setup
        Car car = new Car();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot parkingLot1= superParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= superParkingBoy.addParkingLot(20);
        superParkingBoy.setCarNumber(5, parkingLot1);
        superParkingBoy.setCarNumber(15, parkingLot2);

        //test_Parking
        superParkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(9, superParkingBoy.getFreeSpace());
        Assert.assertEquals(parkingLot1.getParkSize() - 5 - 1,parkingLot1.getFreeNumber());
        Assert.assertEquals(parkingLot2.getParkSize() - 15,parkingLot2.getFreeNumber());
    }

    /**
     * 任务分解2
     * 当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_smart_parkingBoy_take_car_ok(){
        //setup
        Car car = new Car();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot parkingLot1= superParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= superParkingBoy.addParkingLot(20);
        superParkingBoy.setCarNumber(0, parkingLot1);
        superParkingBoy.setCarNumber(0, parkingLot2);
        Ticket ticket;
        //test_Parking
        ticket = superParkingBoy.parkCar(car);
        superParkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, superParkingBoy.getFreeSpace());
        Assert.assertEquals(10,parkingLot1.getFreeNumber());
        Assert.assertEquals(20,parkingLot2.getFreeNumber());
    }

    /**
     * 任务分解3
     * 当存在N个停车场，停车场有车时；任何人拿票取车；空车位+1，取车成功。
     */
    @Test (expected = FullParkingLot.class)
    public void test_smart_parkingBoy_park_car_error(){
        //setup
        Car car = new Car();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot parkingLot1= superParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= superParkingBoy.addParkingLot(20);
        superParkingBoy.setCarNumber(10, parkingLot1);
        superParkingBoy.setCarNumber(20, parkingLot2);

        //test_Parking
        superParkingBoy.parkCar(car);
        //assert
        Assert.assertEquals(0, superParkingBoy.getFreeSpace());
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
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot parkingLot1= superParkingBoy.addParkingLot(10);
        ParkingLot parkingLot2= superParkingBoy.addParkingLot(20);
        superParkingBoy.setCarNumber(0, parkingLot1);
        superParkingBoy.setCarNumber(0, parkingLot2);
        Ticket ticket = new Ticket();
        //test_Parking
        superParkingBoy.takeCar(ticket);
        //assert
        Assert.assertEquals(30, superParkingBoy.getFreeSpace());
        Assert.assertEquals(10,parkingLot1.getFreeNumber());
        Assert.assertEquals(20,parkingLot2.getFreeNumber());
    }

}
