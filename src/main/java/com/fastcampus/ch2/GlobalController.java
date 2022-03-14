package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

// @ControllerAdvice("com.fastcampus.ch2")  // 지정된 패키지에 있는 컨트롤러에서 발생한 예외만 처리 적용
@ControllerAdvice   // 모든 패키지(컨트롤러)에 적용
public class GlobalController {
    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher2(Exception ex, Model m) {
        m.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        m.addAttribute("ex", ex);
        return "error";
    }
}
