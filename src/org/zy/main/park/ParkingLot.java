package park;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:31
 */
public class ParkingLot {
    private int parkSize = 0;
    private int carNumber = 0;
    private int parkId = 0;


    public ParkingLot(int parkSize) {
        this.parkSize = parkSize;
    }

    public int getParkSize() {
        return parkSize;
    }

    public int getFreeNumber() {
        return parkSize - carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getParkId() {
        return parkId;
    }
}
