package cn.tf.weather;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebServiceSoap;

public class WeatherClient1 {

	
	public static void main(String[] args) throws MalformedURLException {
		
		Service service=Service.create(new URL("http://127.0.0.1:11112/weather"),
				new QName("http://jaxws.jaxws.tf.cn/","WeatherInterfaceImplService"));
		
		WeatherWebServiceSoap  portType=service.getPort(WeatherWebServiceSoap.class);

		ArrayOfString result=portType.getWeatherbyCityName("衡阳");
		System.out.println(result);

	}

}
