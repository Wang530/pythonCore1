package cn.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//框架类
@Pro(className = "cn.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //解析注解
        //获取该类的字节码文件
        Class<ReflectTest> ref = ReflectTest.class;
        //获取上边的注解对象
        Pro annotation = ref.getAnnotation(Pro.class);
        //调用注解对象中定义的抽象方法，获取返回值
        String cl = annotation.className();
        String s = annotation.methodName();
        System.out.println(cl);
        System.out.println(s);
        Class<?> aClass = Class.forName(cl);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(s);
        method.invoke(o);


    }
}
