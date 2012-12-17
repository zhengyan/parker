一级工程实践
Author：郑岩 GS122153D
        于佳鑫 GS1221BB5
==============================
作业描述：
1，使用TDD方法，简单设计
2，使用继承，减少代码量，容易维护，而且体现出简单设计的魅力
Parking-->ParkingBoy-->SmartParkingBoy-->SuperParkingBoy-->ParkingManager
3，使用Gradle对代码进行管理、构建、打包测试等

Parking project


任务分解：


作业1：停车场管理
1，当停车场有空车位时；停车；空车位-1，停车成功。
2，当停车场有车时；拿票取车；空车位+1，取车成功。
3，当停车场无空车位时；停车；空车位不变，停车失败。
4，当取车票不存在时；拿票取车；空车位不变，取车失败。

作业2：ParkingBoy
1，当存在N个停车场，停车场有空车位时；停车；空车位-1，停车成功。
2，当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
3，当存在N个停车场，停车场无空车位时；停车；空车位不变，停车失败。
4，当存在N个停车场，取车票不存在时；拿票取车；空车位不变，取车失败。

作业3：SmartParkingBoy
1，当存在N个停车场，停车场有空车位时；停车；选择空车位最多的停车场，空车位-1，停车成功。
2，当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
3，当存在N个停车场，停车场无空车位时；停车；空车位不变，停车失败。
4，当存在N个停车场，取车票不存在时；拿票取车；空车位不变，取车失败。

作业4：SuperParkingBoy
1，当存在N个停车场，停车场有空车位时；停车；选择空置率最高的停车场，空车位-1，停车成功。
2，当存在N个停车场，停车场有车时；拿票取车；空车位+1，取车成功。
3，当存在N个停车场，停车场无空车位时；停车；空车位不变，停车失败。
4，当存在N个停车场，取车票不存在时；拿票取车；空车位不变，取车失败。

最终作业：ParkingManager
1，当存在N个停车场，整个停车场有空车位时；ParkingManager停车；选择全场空置率最高的停车场，空车位-1，停车成功。
2，当存在N个停车场，ParkingBoy管辖范围内停车场有空车位时；ParkingBoy停车；选择自己管辖的停车场，空车位-1，停车成功。
3，当存在N个停车场，整个停车场有车时；ParkingManager拿票取车；空车位+1，取车成功。
4，当存在N个停车场，ParkingBoy管辖范围内停车场有车时；ParkingBoy拿票取车；空车位+1，取车成功。
5，当存在N个停车场，整个停车场无空车位时；ParkingManager停车；空车位不变，停车失败。
6，当存在N个停车场，ParkingBoy管辖范围内停车场无空车位时；ParkingBoy停车；空车位不变，停车失败。
7，当存在N个停车场，取车票在整个停车场不存在时；ParkingManage拿票取车；空车位不变，取车失败。
8，当存在N个停车场，取车票在ParkingBoy管辖范围内不存在时；ParkingBoy拿票取车；空车位不变，取车失败。


输出结果：

ParkingManager:
	车位数：210
	空位数：210
ParkingBoy ID:SuperParkingBoy_001
	ParkingLot ID:3
		车位数：30
		空位数：20
	ParkingLot ID:6
		车位数：60
		空位数：50
	Total车位数：90
	Total空位数：70
ParkingBoy ID:SmartParkingBoy_001
	ParkingLot ID:2
		车位数：20
		空位数：10
	ParkingLot ID:5
		车位数：50
		空位数：40
	Total车位数：70
	Total空位数：50
ParkingBoy ID:ParkingBoy_001
	ParkingLot ID:1
		车位数：10
		空位数：0
	ParkingLot ID:4
		车位数：40
		空位数：30
	Total车位数：50
	Total空位数：30

Process finished with exit code 0