package cn.wdl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LifeDate {
    //计算一个人出生了多少天
    public static void main(String[] args) {

        showTime();

    }
    public static void showTime(){
        System.out.println("请以yyyy-MM-dd的格式输入您的出生日期");
        Scanner scanner = new Scanner(System.in);
        String birthday = scanner.next();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Date date1 = null;
        try {
            date1 = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime() - date1.getTime();
        if (time<0){
            System.out.println("您输入有误，请重新输入！");
            showTime();
        }else{
            System.out.println("已生存"+time/24/60/60/1000+"天");
        }

        ;

    }
}
