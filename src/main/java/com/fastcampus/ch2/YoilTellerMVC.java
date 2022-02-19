package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
// 년월일을 입력하면, 요일을 알려주는 프로그램
public class YoilTellerMVC {
    // 2. 외부로부터의 통신 방식을 통한 통신 연결 메서드
    // http://localhost:8080/ch2/getyoilmvc?year=2022&month=1&day=31
    @RequestMapping("/getyoilmvc")
    public String main(int year, int month, int day, Model model) throws IOException {

        // 1. 유효성 검사
        if (!isVaild(year, month, day)) {
            return "yoilError";
        }

        // 2. 처리 과정 호출
        char yoil = getYoil(year, month, day);

        // 3. Model에 작업 결과 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        // 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil";
    }

    private boolean isVaild(int year, int month, int day) {
        if (year==-1 || month==-1 || day==-1) {
            return false;
        }
        return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크
    }

    private char getYoil(int year, int month, int day) {
        // 작업 : 날짜 세팅
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        // 요일을 알아내는 부문 ex. 1:일요일, 2:월요일...
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}
