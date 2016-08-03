package cn.tf.client;

import cn.tf.jaxws.jaxws.WeatherInterfaceImpl;
import cn.tf.jaxws.jaxws.WeatherInterfaceImplService;

public class WeatherClient {

	
	public static void main(String[] args) {
		WeatherInterfaceImplService  service=new WeatherInterfaceImplService();
		WeatherInterfaceImpl portType=service.getWeatherInterfaceImplPort();
		String result=portType.queryWeather("衡阳");
		System.out.println(result);

	}

}
