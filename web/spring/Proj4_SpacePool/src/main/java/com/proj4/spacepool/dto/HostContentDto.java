package com.proj4.spacepool.dto;

import java.sql.Timestamp;

public class HostContentDto {
	int hId;
	String hName;
	String hTitle;
	String hContent;
	Timestamp hDate;
	int mVote;
	int mReview;
	int mBnum;
	String mFileName1;
	String mFileName2;
	String mFileName3;
	String mFileName4;
	String mFileName5;
	int hPrice;
	
	public HostContentDto() {
		
	}
	
	public HostContentDto(int hId, String hName, String hTitle, String hContent, Timestamp hDate, int mVote, int mReview,
			int mBnum, String mFileName1, String mFileName2, String mFileName3, String mFileName4, String mFileName5, int hPrice) {
		super();
		this.hId = hId;
		this.hName = hName;
		this.hTitle = hTitle;
		this.hContent = hContent;
		this.hDate = hDate;
		this.mVote = mVote;
		this.mReview = mReview;
		this.mBnum = mBnum;
		this.mFileName1 = mFileName1;
		this.mFileName2 = mFileName2;
		this.mFileName3 = mFileName3;
		this.mFileName4 = mFileName4;
		this.mFileName5 = mFileName5;
		this.hPrice = hPrice;
	}

	public int gethPrice() {
		return hPrice;
	}

	public void sethPrice(int hPrice) {
		this.hPrice = hPrice;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String gethTitle() {
		return hTitle;
	}

	public void sethTitle(String hTitle) {
		this.hTitle = hTitle;
	}

	public String gethContent() {
		return hContent;
	}

	public void sethContent(String hContent) {
		this.hContent = hContent;
	}

	public Timestamp gethDate() {
		return hDate;
	}

	public void sethDate(Timestamp hDate) {
		this.hDate = hDate;
	}

	public int getmVote() {
		return mVote;
	}

	public void setmVote(int mVote) {
		this.mVote = mVote;
	}

	public int getmReview() {
		return mReview;
	}

	public void setmReview(int mReview) {
		this.mReview = mReview;
	}

	public int getmBnum() {
		return mBnum;
	}

	public void setmBnum(int mBnum) {
		this.mBnum = mBnum;
	}

	public String getmFileName1() {
		return mFileName1;
	}

	public void setmFileName1(String mFileName1) {
		this.mFileName1 = mFileName1;
	}

	public String getmFileName2() {
		return mFileName2;
	}

	public void setmFileName2(String mFileName2) {
		this.mFileName2 = mFileName2;
	}

	public String getmFileName3() {
		return mFileName3;
	}

	public void setmFileName3(String mFileName3) {
		this.mFileName3 = mFileName3;
	}

	public String getmFileName4() {
		return mFileName4;
	}

	public void setmFileName4(String mFileName4) {
		this.mFileName4 = mFileName4;
	}

	public String getmFileName5() {
		return mFileName5;
	}

	public void setmFileName5(String mFileName5) {
		this.mFileName5 = mFileName5;
	}
	
}