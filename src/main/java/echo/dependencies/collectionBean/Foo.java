package echo.dependencies.collectionBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Foo {
    private Map<String,Float> accounts;
    public void setAccounts(Map<String,Float> accounts){
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "accounts=" + accounts +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("strongTypeInjection.xml");
        Foo foo = (Foo) applicationContext.getBean("foo");
        System.out.println(foo);
    }
}
