package com.study.Pattern.factory;

public class Marine implements Unit {
	public Marine() {
		System.out.println("마린 생성 !");
	}
	
	public void move() {
		System.out.println("마린 이동 ! ");
	}

}
