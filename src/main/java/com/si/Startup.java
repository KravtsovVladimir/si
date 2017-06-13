package com.si;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {
    @SuppressWarnings({"resource", "unused"})
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "/META-INF/spring/si-components.xml");
        while (true) {
        }
    }
}
