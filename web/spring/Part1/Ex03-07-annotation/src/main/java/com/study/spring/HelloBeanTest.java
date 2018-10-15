package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// 1. IoC 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");

		// 2.HelloBean가져오기
		Hello hello= (Hello)context.getBean("hello");
		hello.print();
		
		
		 //3.PrinterBBean가져오기
		Printer	printer=context.getBean("printerB",Printer.class);
		hello.setPrinter(printer); 
		hello.print();
		
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
	}

}
