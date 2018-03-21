package model;

import java.util.Date;

public final class TransferDeal extends Deal {

	Account inputAccount;
	Account outputAccount;
	public Deal parseString(String dealString) {
		return null;
	}

	public TransferDeal(Date dealDate,String dealAmount,String description)
	{
		this.dealType="Transfer";
		this.dealDate=dealDate;
		this.amount=dealAmount;
	}

	public String ToPlainText() {
		return ("<Transfer>\t"+time.format(dealDate)+"\t￥"+amount+" "+description);
	}


	public Account getInputAccount() {
		return inputAccount;
	}


	public void setInputAccount(Account inputAccount) {
		this.inputAccount = inputAccount;
	}


	public Account getOutputAccount() {
		return outputAccount;
	}


	public void setOutputAccount(Account outputAccount) {
		this.outputAccount = outputAccount;
	}
	
}
