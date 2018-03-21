package model;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Deal implements Comparable<Deal> {	
	Date dealDate=new Date();
	String dealType="";
	Person person=null;
	String accountName="";
    String amount="";
	String category="";
	String description="";
	SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public abstract Deal parseString(String dealString);
	public abstract String ToPlainText();
	
	public int compareTo(Deal other)
	{
		if(this.dealDate.getTime()<other.dealDate.getTime())
			return -1;
		else if (this.dealDate.getTime()>other.dealDate.getTime())
			return 1;
		return 0;
	}
	
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
