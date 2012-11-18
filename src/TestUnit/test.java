package TestUnit;

import Parking.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class test {
    Parking park = new Parking();
    Car car = new Car();
    String tid;

    @Before
    public void test_init(){
        park.setFreeSpace(100);

    }
    @Test
    public void test_car_in_area_ok(){
        //setup
        park.setCarNumber(50);
        //test
        park.add(car);
        //assert
        Assert.assertEquals(49, park.getAreaNumber());
    }

    @Test
    public void test_car_out_area_ok(){
        //setup
        park.setCarNumber(0);
        tid = park.add(car);
        //test
        park.minus(tid);
        //assert
        Assert.assertEquals(100, park.getAreaNumber());
    }

    @Test  (expected = FullParkingArea.class)
    public void test_car_in_area_full(){
        //setup
        park.setCarNumber(100);
        //test
        park.add(car);
        //assert
        Assert.assertEquals(0, park.getAreaNumber());
    }

    @Test (expected = UnknownTID.class)
    public void test_car_out_area_empty(){
        //setup
        park.setCarNumber(0);
        //test
        park.minus("A100001");
        //assert
        Assert.assertEquals(100, park.getAreaNumber());

    }
}
