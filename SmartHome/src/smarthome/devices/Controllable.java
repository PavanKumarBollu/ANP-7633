package smarthome.devices;

public interface Controllable {

	int MAX_POWER_LEVEL = 100;

	void turnOn();

	void turnOff();

	void setPower(int level);

}
