package com.fastcampus.ch2;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // 서블릿이 초기화될 때 자동 호출되는 메서드
        // 1. 서블릿의 초기화 작업 담당
        System.out.println("[HelloServlet] init() is called.");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 2. 호출될 때마다 반복적으로 수행됨.
        // 1. 입력
        // 2. 처리
        // 3. 출력
        System.out.println("[HelloServlet] Service() is called.");
    }

    @Override
    public void destroy() {
        // 뒷정리 작업 - 서블릿이 제거(unload)될 때, 단 한번만 수행됨.
        System.out.println("[HelloServlet] destroy() is called.");
    }
}
