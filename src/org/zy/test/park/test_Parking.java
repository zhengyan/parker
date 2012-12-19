package park;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * 作业1：停车场管理
 * User: 郑岩
 * Date: 12-11-11
 * Time: 下午3:17
 */
public class test_Parking {
    //**************************************   第一次作业   **********************************************

    /**
     * 任务分解1
     * 当停车场有空车位时；停车；空车位-1，停车成功。
     */
    @Test
    public void test_car_in_area_ok(){
        //setup
        Parking parking = new Parking();
        Car car = new Car();
        parking.setMaxSpaceNum(100);
        parking.setCarNumber(50);
        //test_Parking
        parking.parkCar(car);
        //assert
        assertEquals(49, parking.getFreeSpace());
    }

    /**
     * 任务分解2
     * 当停车场有车时；拿票取车；空车位+1，取车成功。
     */
    @Test
    public void test_car_out_area_ok(){
        //setup
        Parking parking = new Parking();
        Car car = new Car();
        parking.setMaxSpaceNum(100);
        parking.setCarNumber(0);
        Ticket ticket;
        //test_Parking
        ticket = parking.parkCar(car);
        parking.takeCar(ticket);
        //assert
        assertEquals(100, parking.getFreeSpace());
    }

    /**
     * 任务分解3
     * 当停车场无空车位时；停车；空车位不变，停车失败。
     */
    @Test (expected = FullParkingLot.class)
    public void test_car_in_area_full(){
        //setup
        Parking parking = new Parking();
        Car car = new Car();
        parking.setMaxSpaceNum(100);
        parking.setCarNumber(100);
        //test_Parking
        parking.parkCar(car);
        //assert
        assertEquals(0, parking.getFreeSpace());
    }

    /**
     *  任务分解4
     *  当停车场无车时；拿票取车；空车位不变，取车失败。
     */
    @Test (expected = UnknownTID.class)
    public void test_car_out_area_empty(){
        //setup
        Parking parking = new Parking();
        parking.setMaxSpaceNum(100);
        parking.setCarNumber(0);
        //test_Parking
        parking.takeCar(new Ticket());
        //assert
        assertEquals(100, parking.getFreeSpace());
    }
}
