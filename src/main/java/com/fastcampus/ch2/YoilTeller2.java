package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
// 년월일을 입력하면, 요일을 알려주는 프로그램
public class YoilTeller2 {
    // 2. 외부로부터의 통신 방식을 통한 통신 연결 메서드
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 입력
        // 브라우저(외부)부터 날짜와 요일을 위한 변수의 값을 받음
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 2. 작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm-1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        // 3. 출력
        // 요청받은 브라우저(외부)로 요청 결과를 전송하는 출력(브라우저로 결과를 확인 가능함)
        response.setContentType("text/html");   // 응답의 형식을 html로 지정
        response.setCharacterEncoding("utf-8"); // 응답의 인코딩 형식을 utf-8로 지정
        PrintWriter out = response.getWriter(); // 브라우저로 출력 스트림(out)을 얻음
        // 출력 스트림 내용 입력 설정 부분 시작 //
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "년 " + month + "월 " + day + "일은 ");
        out.println(yoil + "요일입니다.");
        out.println("</body>");
        out.println("</html>");
        out.close();
        // 출력 스트림 내용 입력 설정 부분 끝 //
    }
}
