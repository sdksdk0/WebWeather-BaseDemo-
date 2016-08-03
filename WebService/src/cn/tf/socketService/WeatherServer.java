package cn.tf.socketService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//天气查询服务器
public class WeatherServer {


	public static void main(String[] args) throws IOException {
		//创建一个socket服务
		//参数：服务的端口号，
		ServerSocket serverSocket=new ServerSocket(11111);
		System.out.println("服务端已启动");
		
		while(true){
		
		
		//等待客户端建立连接
		final Socket socket=serverSocket.accept();
		
		
		Runnable runnable=new Runnable() {
			
			public void run() {
				
				DataInputStream inputStream = null;
				DataOutputStream outputStream = null;
				
				try {
					//使用输入流读取客户端发送的数据
					inputStream=new DataInputStream(socket.getInputStream());
					String cityName=inputStream.readUTF();
					
					System.out.println(cityName);
					
					//根据城市查询天气
					System.out.println("查询天气");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					String resultString="高温红色预警";
					
					 outputStream=new DataOutputStream(socket.getOutputStream());
					
					//返回查询结果
					System.out.println("返回结果:"+resultString);
					outputStream.writeUTF(resultString);
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
				
					try {
						inputStream.close();
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//启动线程
		new Thread(runnable).start();

		}
		
		
	}

}
