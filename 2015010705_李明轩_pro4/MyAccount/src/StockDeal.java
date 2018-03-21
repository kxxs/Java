
public final class StockDeal extends Deal {
    boolean isBuy=true;
    String stockNumber="";
    String stockName="";
    
	
	
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

	Deal parseString(String dealString) {
		return null;
	}

	String ToPlainText() {
		return null;
	}

}
