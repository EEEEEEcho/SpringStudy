package echo.dependencies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("constructorDIContext.xml");
        //TextEditor textEditor = (TextEditor)app.getBean("textEditor");
        //textEditor.spellCheck();
        ExampleBean exampleBean = (ExampleBean) app.getBean("exampleBean");
        System.out.println(exampleBean);
        SimpleMovieListener simpleMovieListener = (SimpleMovieListener) app.getBean("simpleMovieListener");
        System.out.println(simpleMovieListener);
    }
}
