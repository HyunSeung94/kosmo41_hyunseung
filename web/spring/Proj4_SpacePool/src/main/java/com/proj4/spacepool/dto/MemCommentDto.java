package com.proj4.spacepool.dto;

import java.sql.Timestamp;

public class MemCommentDto {
	int cId;
	int bId;
	String cName;
	Timestamp cDate;
	String cContent;
	int cArlam;
	int cParent;
	
	public MemCommentDto() {
		
	}

	public MemCommentDto(int cId, int bId, String cName, Timestamp cDate, String cContent, int cArlam, int cParent) {
		super();
		this.cId = cId;
		this.bId = bId;
		this.cName = cName;
		this.cDate = cDate;
		this.cContent = cContent;
		this.cArlam = cArlam;
		this.cParent = cParent;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public int getcArlam() {
		return cArlam;
	}

	public void setcArlam(int cArlam) {
		this.cArlam = cArlam;
	}

	public int getcParent() {
		return cParent;
	}

	public void setcParent(int cParent) {
		this.cParent = cParent;
	}
	
	
	
}