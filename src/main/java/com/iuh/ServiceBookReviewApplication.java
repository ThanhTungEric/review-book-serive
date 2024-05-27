package com.iuh;

import com.iuh.config.RateLimiterFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServiceBookReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBookReviewApplication.class, args);
    }
    @Bean
    public FilterRegistrationBean<RateLimiterFilter> loggingFilter(){
        FilterRegistrationBean<RateLimiterFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RateLimiterFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

}
