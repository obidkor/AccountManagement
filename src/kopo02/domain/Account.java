package kopo02.domain;

import java.util.Date;

public class Account {
	private int id;
	private String title;
	private Date created;//날짜형은 java.util을 임포트
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
