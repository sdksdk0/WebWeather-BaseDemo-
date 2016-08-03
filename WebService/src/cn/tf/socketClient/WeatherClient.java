package cn.tf.socketClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



//客户端
public class WeatherClient {


	public static void main(String[] args) throws UnknownHostException, IOException {
		
		while(true){
		
		Socket socket=new Socket("localhost",11111);
		
		//使用输出流发送城市名称
		DataOutputStream  outputStream=new DataOutputStream(socket.getOutputStream());
		
		//发送城市名称
		outputStream.writeUTF("衡阳");
		
		DataInputStream inputStream=new DataInputStream(socket.getInputStream());
		String resultString=inputStream.readUTF();
		
		System.out.println("天气信息"+resultString);
		
		//关闭流
		inputStream.close();
		outputStream.close();
		}

	}

}
