package smarthome.devices;

public class SmartAC implements Controllable {
	
	private boolean isOn;
	
	private int temperature;
		
	
	
	

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public void turnOn() {
	isOn = true;

	}

	@Override
	public void turnOff() {
		isOn = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void setPower(int level) {
		if(level <= MAX_POWER_LEVEL)
		{
			temperature = level;
		}

	}

}
