package smarthome.devices;

public class SmartLight implements Controllable {

	private boolean isOn;
	private int brightness;

	@Override
	public void turnOn() {
		isOn = true;
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		isOn = false;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	@Override
	public void setPower(int level) {

		if (level <= MAX_POWER_LEVEL) {
			brightness = level;
		}

	}

}
