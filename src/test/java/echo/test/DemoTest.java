package echo.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 一切框架设计都要考虑扩展性，
 * 1.抽象
 * 2.设计模式：前任总结出来的一种具有扩展性的思想
 *
 * spring提出的扩展
 * 1.创建对象之前可以做一些工作
 * 2.容器初始化之前可以做些事
 * 3.在不同的阶段发出不同的事件，做一些工作
 * 4.抽象出各种接口，
 * 5.面向接口编程
 */
public class DemoTest {
    @Test
    public void testField() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();
        //getDeclaredFields获取所有声明的实例变量，无论修饰符，但是无法获取父类的。
//        Field[] declaredFields = aClass.getDeclaredFields();
//        Arrays.asList(declaredFields).stream().forEach(System.out::println);


        //创建一个userService对象
        UserService userService = new UserService();
        
        // 1.注入的方式一，通过set方法注入
        // 获取userService属性的引用
        Field userServiceField = aClass.getDeclaredField("userService");
        userServiceField.setAccessible(true);
        // 该属性的名称
        String userServiceFieldName = userServiceField.getName();
        userServiceFieldName = userServiceFieldName.substring(0,1).toUpperCase()
                + userServiceFieldName.substring(1,userServiceFieldName.length());
        // get方法名
        String getMethodName = "get" + userServiceFieldName;
        // set方法名
        String setMethodName = "set" + userServiceFieldName;
        // 获取set方法
        Method method = aClass.getMethod(setMethodName, UserService.class);
        method.setAccessible(true);
        // 调用 userService是传入的参数，
        method.invoke(userController,userService);
        System.out.println(getMethodName);

        //2.注入的方式二，通过属性直接注入
        //将userService对象注入到它的引用中
        Field userServiceField2 = aClass.getDeclaredField("userService");
        userServiceField2.setAccessible(true);
        userServiceField2.set(userController,userService);
        System.out.println(userController.getUserService());

        //3.注入的方式三，通过注解注入
        Stream.of(aClass.getDeclaredFields()).forEach(
                field -> {
                    String name = field.getName();
                    Autowired annotation = field.getAnnotation(Autowired.class);
                    if(annotation != null){
                        field.setAccessible(true);
                        //获取类型信息
                        Class<?> type = field.getType();
                        try {
                            /**
                             * 这个对象是直接newInstance出来的
                             * 在spring中 这个bean是定义在注解或者xml中的，如何找到？
                             */
                            Object newInstance = type.getConstructor().newInstance();
                            field.set(userController,newInstance);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }

                }
        );
    }
}
