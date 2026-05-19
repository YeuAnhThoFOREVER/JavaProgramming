package day11;

import java.util.*;

public class CalendarTest {

    public static void main(String[] args) {
        
        Calendar now = Calendar.getInstance();
        
        System.out.println("현재 날짜와 시간");
        
        // Date part
        System.out.print(now.get(Calendar.YEAR) + "년 ");
        System.out.print((now.get(Calendar.MONTH) + 1) + "월 ");
        System.out.print(now.get(Calendar.DAY_OF_MONTH) + "일 ");
        
        // Time part (Hours, Minutes, Seconds)
        System.out.print(now.get(Calendar.HOUR_OF_DAY) + "시 ");
        System.out.print(now.get(Calendar.MINUTE) + "분 ");
        System.out.println(now.get(Calendar.SECOND) + "초");
        
    }
}