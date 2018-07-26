package com.study.pattern03.simple_factory1;

public class Firebat implements Unit {
	
	public Firebat() {
		System.out.println("파이어벳 생성 !!");
	}

	@Override
	public void move() {
		System.out.println("파이어벳 이동!!!");

	}

}