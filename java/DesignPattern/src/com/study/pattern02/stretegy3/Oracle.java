package com.study.pattern02.stretegy3;

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
