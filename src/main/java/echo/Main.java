package echo;

import echo.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("userBeans.xml");
        User user = (User)beanFactory.getBean("user");
        System.out.println(user);

        ApplicationContext context = new ClassPathXmlApplicationContext("userBeans.xml");
        User user1 = context.getBean("user", User.class);
        System.out.println(user1.getUsername());

        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericApplicationContext).loadBeanDefinitions("userBeans.xml");
        genericApplicationContext.refresh();
        Object user2 = genericApplicationContext.getBean("user");
        System.out.println(user2);
    }
}
