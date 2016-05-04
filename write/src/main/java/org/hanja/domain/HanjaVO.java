package org.hanja.domain;

import java.util.Date;

public class HanjaVO {
	
	private String chinesetext, meantext;
	private Date regdate, updatedate;
	private int cno, writecount, grade, edgenum;
	public String getChinesetext() {
		return chinesetext;
	}
	public void setChinesetext(String chinesetext) {
		this.chinesetext = chinesetext;
	}
	public String getMeantext() {
		return meantext;
	}
	public void setMeantext(String meantext) {
		this.meantext = meantext;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getWritecount() {
		return writecount;
	}
	public void setWritecount(int writecount) {
		this.writecount = writecount;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getEdgenum() {
		return edgenum;
	}
	public void setEdgenum(int edgenum) {
		this.edgenum = edgenum;
	}
	@Override
	public String toString() {
		return "HanjaVO [chinesetext=" + chinesetext + ", meantext=" + meantext + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", cno=" + cno + ", writecount=" + writecount + ", grade=" + grade
				+ ", edgenum=" + edgenum + "]";
	}
	
	
	
	
}
