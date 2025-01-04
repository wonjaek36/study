package io.github.wonjaek36.tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // HomeController를 대체하는 코드
        // 루트 경로(/)로 요청이 오면, ViewControllerRegistration 객체의 setViewName() 메서드를 호출하여 home 뷰 이름을 지정
        registry.addViewController("/").setViewName("home");
    }
}
