package cn.tf.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jdk.internal.org.xml.sax.InputSource;

//使用http的方式调用服务端方法
public class SoapHttpClient {


	public static void main(String[] args) throws IOException {
		URL url=new  URL("http://127.0.0.1:11112/weather");
		
		//创建一个HttpURLConnection对象
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//服务端是soap1.2的协议
		connection.setRequestProperty("Content-Type", " application/soap+xml; charset=utf-8;");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		//使用输出流向服务端发送xml数据
				connection.getOutputStream().write(getRequestBody("北京").getBytes());
				//接收服务端响应的内容
				InputStream inputStream = connection.getInputStream();
				byte[] b = new byte[1024];
				int len = 0;
				ByteArrayOutputStream data = new ByteArrayOutputStream();
				while((len = inputStream.read(b, 0, 1024)) != -1) {
					data.write(b, 0, len);
				}
				
				System.out.println(data);
	}
	//拼装请求协议体
	private static String getRequestBody(String cityName){
		
		String body = "<?xml version=\"1.0\" ?>\n" +
				"<S:Envelope xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
				"	<S:Body>\n" +
				"		<ns2:queryWeather xmlns:ns2=\"http://jaxws.jaxws.tf.cn/\">\n" +
				"			<arg0>"+cityName+"</arg0>\n" +
				"		</ns2:queryWeather>\n" +
				"	</S:Body>\n" +
				"</S:Envelope>";
		return body;
	}
	
	

}
