package main;

public class GreenCar implements Car{

	@Override
	public String startCar() {
		return "녹차 시동 걸었음";
	}

	@Override
	public void go() {
		System.out.println("녹차, 바람으로 감");
	}

	@Override
	public int stop() {
		return 80;
	}

}
