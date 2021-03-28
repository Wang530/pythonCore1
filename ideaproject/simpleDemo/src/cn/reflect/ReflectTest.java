package cn.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

//框架类
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可创建任意类型的对象
        //不能改变该类的代码
        /*
        实现
            配置文件

            反射
            将需要创建的对象的全类名和需要执行的方法定义在配置文件中
            在程序中加载读取配置文件
            使用反射技术加载类文件进内存
            创建对象
            执行方法
         */
        //创建properties对象
        Properties pro = new Properties();
        //加载配置文件，转换为集合
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");

        pro.load(is);
        //获取配置文件中的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //加载该类进内存
        Class cls = Class.forName(className);
        //创建对象
        Object o = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(o);
    }
}
