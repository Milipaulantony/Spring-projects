package car.example.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context
               = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        myBean newobj = (myBean)context.getBean("MyBean");
        System.out.println(newobj);

    }
}
