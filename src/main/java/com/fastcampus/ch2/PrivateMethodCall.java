package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

    public static void main(String[] args) throws Exception {
/*        Hello hello = new Hello();
        hello.main3();*/  // private로 인한 외부 호출 불가

        // Spring Framework에서 많이 쓰이고 있는 API에 대해 알아봄
        // Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공
        // java.lang.reflection 패키지를 제공
        Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
        Hello hello = (Hello) helloClass.newInstance(); // Class 객체가 가진 정보로 객체를 생성
        Method main = helloClass.getDeclaredMethod("main3");
        main.setAccessible(true);
        
        main.invoke(hello); // hello.main(); 과 동일함
    }
}
