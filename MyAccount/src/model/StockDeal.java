package model;

import java.util.Date;

public final class StockDeal extends Deal {
    boolean isBuy=true;
    String stockNumber="";
    String stockName="";
    
	public StockDeal(Date dealDate,String dealAmount,String description)
	{
		this.dealType="Stock   ";
		this.dealDate=dealDate;
		this.amount=dealAmount;
	}
	
	public boolean isBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Deal parseString(String dealString) {
		return null;
	}

	public String ToPlainText() {
		return ("<Stock>\t\t"+time.format(dealDate)+"\t￥"+amount+" "+description);
	}

}
