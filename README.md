# WebWeather-BaseDemo-
基于webService的天气查询案例，基础版，未连接公网的，socket、webservice、wsdl使用过程生成的代码来创建客户端
##服务端开发

1、编写一个SEI,也就是一个接口

    public interface WeatherInterface {
    
    	String queryWeather(String cityName);
    
    }

2、编写一个SEI实现类，需要实现SEI接口，而且还需要在这个实现类上面添加一个@Webservice注解

	@Webservice
    public class WeatherInterfaceImpl implements WeatherInterface {
    
    	public String queryWeather(String cityName) {
    		System.out.println("接收到客户端发送的城市名称:"+cityName);	
    		String result="晴,高温预警";
    		return result;
    	}
    }



3、发布服务。使用Endpoint的静态方法publish。

    public class WeatherServer {
    
    	
    	public static void main(String[] args) {
    		//发布服务
    		Endpoint.publish("http://127.0.0.1:11111/weather", new WeatherInterfaceImpl());
    	}
    
    }


访问地址：http://127.0.0.1:11111/weather

http://127.0.0.1:11111/weather?wsdl中看到ImplPort。

看到效果则说明启动成功了。

##客户端
使用Wsimport生成客户端调用代码，
在jdk的安装目录的bin目录中，有一个wsimport命令。

可以根据wsdl文档生成客户端调用代码。

生成WebServiceWSGEN
在src目录下通过cmd运行以下命令：

wsimport -s . http://127.0.0.1:11111/weather?wsdl


###实现步骤
使用过程生成的代码来创建客户端

1、创建一个服务视图对象
2、从服务试图获得porttype（SEI）对象
3、调用服务端方法
4、打印结果

    public class WeatherClient {
    
    	
	public static void main(String[] args) {
		WeatherInterfaceImplService  service=new WeatherInterfaceImplService();
		WeatherInterfaceImpl portType=service.getWeatherInterfaceImplPort();
		String result=portType.queryWeather("衡阳");
		System.out.println(result);

	}
    }
