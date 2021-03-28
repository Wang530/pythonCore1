package cn.wdl;

import java.util.Calendar;

public class CalenderDemo {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        System.out.println(Calendar.DATE);
        instance.add(Calendar.DATE,1);
        System.out.println(Calendar.DATE);
        System.out.println(instance.get(Calendar.YEAR));
    }
}
