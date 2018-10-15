package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		String configLocation = "classpath:beans.xml";

		// 1. IoC 컨테이너 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(configLocation);

		// 2.Hello Bean가져오기
		Hello hello= (Hello)context.getBean("hello");
		hello.print();
		
		 //3.Printer BBean가져오기
		Printer	printer=context.getBean("printerB",Printer.class);
		hello.setPrinter(printer); 
		hello.print();
		
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		context.close();
	}

}
