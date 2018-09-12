package com.study.room;


public class RDto {

	//방 
	int rnum;
	String rid;
	String roomname;
	String position;
	
	public RDto(int rnum, String rid, String roomname, String position) 
	{
		this.rnum = rnum;
		this.rid = rid;
		this.roomname = roomname;
		this.position = position;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}



}
