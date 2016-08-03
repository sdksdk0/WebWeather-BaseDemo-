package cn.tf.jaxws.jaxws;

import javax.xml.ws.Endpoint;

public class WeatherServer {

	
	public static void main(String[] args) {
		//发布服务
		Endpoint.publish("http://127.0.0.1:11111/weather", new WeatherInterfaceImpl());
	}

}
