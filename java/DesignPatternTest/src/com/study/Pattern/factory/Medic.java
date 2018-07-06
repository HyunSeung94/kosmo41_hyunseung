package com.study.Pattern.factory;

public class Medic implements Unit{
	public Medic() {
		System.out.println("메딕 생성!");
	}
	
	@Override
	public void move() {
		System.out.println("메딕 이동!!");
	}

}
