package com.proj4.spacepool.dto;

import java.sql.Timestamp;

public class MemContentDto {
	int mId;
	String mName;
	String mTitle;
	String mContent;
	Timestamp mDate;
	int mHit;
	int mGroup;
	int mStep;
	int mIndent;
	int mBnum;
	String mFileName;
	int mArlam;
	
	public MemContentDto() {
		
	}

	public MemContentDto(int mId, String mName, String mTitle, String mContent, Timestamp mDate, int mHit, int mGroup,
			int mStep, int mIndent, int mBnum, String mFileName, int mArlam) {
		this.mId = mId;
		this.mName = mName;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.mDate = mDate;
		this.mHit = mHit;
		this.mGroup = mGroup;
		this.mStep = mStep;
		this.mIndent = mIndent;
		this.mBnum = mBnum;
		this.mFileName = mFileName;
		this.mArlam = mArlam;
	}


	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public Timestamp getmDate() {
		return mDate;
	}

	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}

	public int getmHit() {
		return mHit;
	}

	public void setmHit(int mHit) {
		this.mHit = mHit;
	}

	public int getmGroup() {
		return mGroup;
	}

	public void setmGroup(int mGroup) {
		this.mGroup = mGroup;
	}

	public int getmStep() {
		return mStep;
	}

	public void setmStep(int mStep) {
		this.mStep = mStep;
	}

	public int getmIndent() {
		return mIndent;
	}

	public void setmIndent(int mIndent) {
		this.mIndent = mIndent;
	}

	public int getmBnum() {
		return mBnum;
	}

	public void setmBnum(int mBnum) {
		this.mBnum = mBnum;
	}

	public String getmFileName() {
		return mFileName;
	}

	public void setmFileName(String mFileName) {
		this.mFileName = mFileName;
	}

	public int getmArlam() {
		return mArlam;
	}

	public void setmArlam(int mArlam) {
		this.mArlam = mArlam;
	}
	
}