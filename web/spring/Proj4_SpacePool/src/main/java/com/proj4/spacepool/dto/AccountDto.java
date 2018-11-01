package com.proj4.spacepool.dto;

public class AccountDto {
	String sId;
	String sPwd;
	int userMode;
	String sRank;
	String sNickName;
	int sAlert;
	
	public AccountDto() {
		
	}

	public AccountDto(String sId, String sPwd, int userMode, String sRank, String sNickName, int sAlert) {
		super();
		this.sId = sId;
		this.sPwd = sPwd;
		this.userMode = userMode;
		this.sRank = sRank;
		this.sNickName = sNickName;
		this.sAlert = sAlert;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPwd() {
		return sPwd;
	}

	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}

	public int getUserMode() {
		return userMode;
	}

	public void setUserMode(int userMode) {
		this.userMode = userMode;
	}

	public String getsRank() {
		return sRank;
	}

	public void setsRank(String sRank) {
		this.sRank = sRank;
	}

	public String getsNickName() {
		return sNickName;
	}

	public void setsNickName(String sNickName) {
		this.sNickName = sNickName;
	}

	public int getsAlert() {
		return sAlert;
	}

	public void setsAlert(int sAlert) {
		this.sAlert = sAlert;
	}
}