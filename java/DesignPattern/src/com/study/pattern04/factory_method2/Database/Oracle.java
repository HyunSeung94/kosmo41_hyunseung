package com.study.pattern04.factory_method2.Database;

// <summary>
// B 'ConcreteCreator' class
// <summary>

public class Oracle extends Database {
	
	public Oracle() {
		name = "Oracle";
		rows = 20;
	}

	@Override
	public void connectDatabase() {
		System.out.println(name + "에 접속했습니다.");

	}


}
