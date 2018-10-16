package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		
		//String configLocation = "classpath:beans.xml";

		//1. 1개 이상의 설정 파일 경로를 값으로 전달 가능 : 가변 인자 형태임
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				Config.class);
		
		
		// 2.HelloBean가져오기
		Hello helloA= (Hello)context.getBean("hello");
		helloA.print();
		
		// 3.HelloBean가져오기
		Hello helloB= (Hello)context.getBean("hello1");
		helloB.print();
		
		//4.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		helloA.setPrinter(printer);
		helloA.print();
		
		//5.싱글톤인지 확인
		System.out.println(helloA == helloB);
		
		context.close();
		
		
		
//		컨테이너 생성은 다음과 같이도 가능
//		ApplicationContext context = new AnnotationConfigApplicationContext(
//				Config.class);
//		이 경우 context.close(); 주석 처리!!!

		 
	}

}
