package smarthome.main;

import smarthome.devices.SmartAC;
import smarthome.devices.SmartLight;

public class HomeApp {

	public static void main(String[] args) {
		
		
		SmartLight smartLight = new SmartLight();
		smartLight.setPower(100);
		
		if(smartLight.isOn())
		{
			System.out.println("Light is on");
			System.out.println("Brightness Level :" + smartLight.getBrightness());
		}
		else
		{
			System.out.println("light is off");
			System.out.println("Brightness Level :" + smartLight.getBrightness());
		}
		
		
		SmartAC smartAC = new SmartAC();
		if(smartAC.isOn())
		{
			System.out.println("AC is on");
			System.out.println("Temparature Level :" + smartAC.getTemperature());
		}
		else
		{
			System.out.println("AC is off");
			System.out.println("Temparature Level :" + smartAC.getTemperature());
		}
		
		
		

	}

}
