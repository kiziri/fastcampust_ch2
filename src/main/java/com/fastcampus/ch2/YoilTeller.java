package com.fastcampus.ch2;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class YoilTeller {
    // 1. 일반 static 메서드의 통신
    public static void main(String[] args) {
        // 1. 입력
        // 일반적인 날짜와 요일을 위한 변수 선언
        String year = args[0];
        String month = args[1];
        String day = args[2];

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm-1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        // 3. 출력
        // 콘솔에 출력을 하여 사이트 화면에 나오진 않음
        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
        System.out.println(yoil + "요일입니다.");
    }
}
