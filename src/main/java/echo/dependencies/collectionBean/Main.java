package echo.dependencies.collectionBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionBean.xml");
        ComplexObject complexObject = (ComplexObject) applicationContext.getBean("complexObject");
        System.out.println(complexObject);
    }
}
