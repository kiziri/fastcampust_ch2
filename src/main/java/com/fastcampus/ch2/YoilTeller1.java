package com.fastcampus.ch2;

import java.util.Calendar;

// 년월일을 입력하면, 요일을 알려주는 프로그램
public class YoilTeller1 {
    // 1. 일반 static 메서드의 통신
    public static void main(String[] args) {
        // 1. 입력 : 매개변수로 스트링 문자열로 받아 저장
        // 일반적인 날짜와 요일을 위한 변수 선언
        String year = args[0];
        String month = args[1];
        String day = args[2];

        // 문자열을 정수(숫자)로 변환
        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 작업 : 날짜 세팅
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm-1, dd);

        // 요일을 알아내는 부문 ex. 1:일요일, 2:월요일...
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        // 3. 출력
        // 콘솔에 출력을 하여 사이트 화면에 나오진 않음
        System.out.println(year + "년 " + month + "월 " + day + "일은 ");
        System.out.println(yoil + "요일입니다.");
    }
}
