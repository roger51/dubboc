package roger.dubboc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.qunar.roger.dubboapi.DemoService;

public class Custom {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        new String[] { "dubbo-demo-consumer.xml" });
    context.start();

    DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
    try {
    	String hello = demoService.sayHello("world");
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
    } catch (Exception e) {
        e.printStackTrace();
    }
 

  }

}
