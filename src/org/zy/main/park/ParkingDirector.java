package park;

/**
 * Final Mission：ParkingDirector
 * User: 郑岩
 * Date: 12-11-25
 * Time: 下午5:01
 */
public class ParkingDirector {

    public void showReport(ParkingManager parkingManager) {
        Object[] parkingBoyIdList;
        ParkingBoy parkingBoy;
        ParkingLot parkingLot;
        String id;
        System.out.println("ParkingManager:");
        System.out.println("\t车位数：" + parkingManager.getMaxSpaceNum());
        System.out.println("\t空位数：" + parkingManager.getMaxSpaceNum());
        parkingBoyIdList = parkingManager.parkingBoyList.keySet().toArray();
        for (int i = 0; i < parkingManager.parkingBoyList.size(); i++) {
            id = String.valueOf(parkingBoyIdList[i]);
            parkingBoy = parkingManager.parkingBoyList.get(id);
            System.out.println("ParkingBoy ID:" + id);
            for (int j=0; j<parkingBoy.parkList.size();j++){
                parkingLot = parkingBoy.parkList.get(j)  ;
                System.out.println("\tParkingLot ID:" + parkingLot.getParkId());
                System.out.println("\t\t车位数：" + parkingLot.getParkSize());
                System.out.println("\t\t空位数：" + parkingLot.getFreeNumber());
            }
            System.out.println("\tTotal车位数：" + parkingBoy.getMaxSpaceNum());
            System.out.println("\tTotal空位数：" + parkingBoy.getFreeSpace());
        }
    }

    public static void main(String[] args) {
        ParkingManager parkingManager;
        ParkingBoy parkingBoy;
        SmartParkingBoy smartParkingBoy;
        SuperParkingBoy superParkingBoy;
        ParkingLot parkingLot1;
        ParkingLot parkingLot2;
        ParkingLot parkingLot3;
        ParkingLot parkingLot4;
        ParkingLot parkingLot5;
        ParkingLot parkingLot6;

        parkingManager = new ParkingManager();
        parkingBoy = new ParkingBoy();
        smartParkingBoy = new SmartParkingBoy();
        superParkingBoy = new SuperParkingBoy();
        parkingManager.addParkingBoy("ParkingBoy_001", parkingBoy);
        parkingManager.addParkingBoy("SmartParkingBoy_001", smartParkingBoy);
        parkingManager.addParkingBoy("SuperParkingBoy_001", superParkingBoy);

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

        parkingManager.setCarNumber(10, parkingLot1);
        parkingManager.setCarNumber(10, parkingLot2);
        parkingManager.setCarNumber(10, parkingLot3);
        parkingManager.setCarNumber(10, parkingLot4);
        parkingManager.setCarNumber(10, parkingLot5);
        parkingManager.setCarNumber(10, parkingLot6);


        ParkingDirector parkingDirector = new ParkingDirector();
        //展示报表
        parkingDirector.showReport(parkingManager);
    }
}
