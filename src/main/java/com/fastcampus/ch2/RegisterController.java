package com.fastcampus.ch2;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @InitBinder
    public void toDate(WebDataBinder binder) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
        binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
    }

//	@RequestMapping(value="/register/add", method=RequestMethod.GET) // 신규회원 가입
    @GetMapping("/add") // 4.3부터 추가
    public String register() {

        return "registerForm";
    }

    //@RequestMapping(value = "/register/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(User user, BindingResult result, Model m) throws UnsupportedEncodingException {
        System.out.println("result = " + result);
        System.out.println("user = " + user);

        // 1. 유효성 검사
        if(!isValid(user)) {
            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");

            m.addAttribute("msg", msg);
            return "redirect:/register/add"; // 신규회원 가입화면으로 이동(redirect)
        }
        
        // 2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }

    private boolean isValid(User user) {
        return false;
    }
}
