package cn.reflect;

import java.lang.reflect.Field;

public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<Person> personClass = Person.class;
        //获取成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-------------");
        Field a = personClass.getField("b");
        Person person = new Person();
        Object value = a.get(person);
        System.out.println(value);
        a.set(person,"张三");
        System.out.println(person);
        System.out.println("=====================");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);//暴力反射
        Person person1 = new Person();
        Object o = name.get(person1);
        System.out.println(o);
    }

}
