package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		// 현재 실행중인 IoC Container 를 반환
		// 그리고 IoC Container는 클래스를 객체로 만들어서 내부에서 관리함
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		// 그 Container가 어떤 Bean 객체를 가지고 있는지 확인해보기
		for(String beanName : applicationContext.getBeanDefinitionNames())
			System.out.println(beanName);
	}

}
