package com.study.pattern04.factory_method1.Unit;

public class Marine extends Unit{
	
	public Marine() {
		type = UnitType.Marine;
		name = "Marine";
		hp = 100;
		exp = 100;
		
		System.out.println(this.name + "생성 !!!!");
	}
	
	@Override
	public void attack() {
		System.out.println(this.name + " 공격 !!!!!");
	}

}
