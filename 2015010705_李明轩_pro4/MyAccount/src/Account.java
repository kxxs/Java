
public abstract class Account {
		String name;
		String type;
		String accountnumber;
		String description;
		Person belongto;
		String curency;
		List dealList;
		
	    abstract String getReport(Date start,Date end,int reportType);

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getAccountnumber() {
			return accountnumber;
		}
		public void setAccountnumber(String accountnumber) {
			this.accountnumber = accountnumber;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Person getBelongto() {
			return belongto;
		}
		public void setBelongto(Person belongto) {
			this.belongto = belongto;
		}
		public String getCurency() {
			return curency;
		}
		public void setCurency(String curency) {
			this.curency = curency;
		}
		public List getDealList() {
			return dealList;
		}
		public void setDealList(List dealList) {
			this.dealList = dealList;
		}
	
		
}
