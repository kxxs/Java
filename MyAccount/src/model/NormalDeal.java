package model;

import java.util.Date;

public class NormalDeal extends Deal{
	public Deal parseString(String dealString) {
		return null;
	}
	
	public NormalDeal(Date dealDate,String dealAmount,String description)
	{
		this.dealType="Normal  ";
		this.dealDate=dealDate;
		this.amount=dealAmount;
	}

	public String ToPlainText() {
		return ("<Normal>\t"+time.format(dealDate)+"\t￥"+amount+" "+description);
	}
}
