package car.example.setter.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_Car_example {
    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationSetterContext.xml");
        Car myCar = (Car)context.getBean("MyCar");
        myCar.displayDetails();
    }
}
