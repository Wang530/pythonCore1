package cn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo0 {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Person person = constructor.newInstance("张三", 22);
        System.out.println(person);
        System.out.println("----------------------");
        Constructor<Person> constructor1 = personClass.getConstructor();
        Person person1 = constructor1.newInstance();
        System.out.println(person1);
        System.out.println(personClass.newInstance());
    }

}
