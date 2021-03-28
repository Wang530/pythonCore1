package cn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<Person> personClass = Person.class;
        Method eat = personClass.getMethod("eat");
        Person person = new Person();
        Object invoke = eat.invoke(person);
        Method method = personClass.getMethod("eat",String.class);
        method.invoke(person,"baozi");
        Method[] methods = personClass.getMethods();
        for (Method method1 : methods) {
            System.out.println(method1);
            System.out.println(method1.getName());
        }
        String name = personClass.getName();
        System.out.println(name);
    }

}
