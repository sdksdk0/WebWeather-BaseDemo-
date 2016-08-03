package cn.tf.weather;

import java.net.MalformedURLException;
import java.net.URL;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebService;
import cn.com.webxml.WeatherWebServiceSoap;

public class Client {

	public static void main(String[] args) {
		//创建服务视图
		//WeatherWebService  service=new WeatherWebService();
		
		URL url = null;
		try {
			url = new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?WSDL");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		QName qName=new QName("http://WebXml.com.cn/", "WeatherWebService");
		
		Service service=Service.create(url,qName);
		WeatherWebServiceSoap  portType=service.getPort(WeatherWebServiceSoap.class);
				//service.getWeatherWebServiceSoap();
		
		ArrayOfString arrayOfString=portType.getWeatherbyCityName("衡阳");
		for (String string : arrayOfString.getString()) {
			System.out.println(string);
		}
	}

}
