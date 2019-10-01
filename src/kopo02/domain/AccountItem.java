package kopo02.domain;

import java.sql.Timestamp;
import java.util.Date;

public class AccountItem {
	private int id;
	private Account account;//FK가 되는 것은 자료형을 부모 엔티티의 이름으로 정해줌
//	private int account_id;
	private String title;
	private Timestamp created;
	private int price;
	private String type;
	private String payment;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
		
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
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	
	
}
