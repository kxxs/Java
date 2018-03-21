package problem2;
public class Calculator2 { 
	public static float getPrice(String type) throws Exception {
		// 获得产品单价 
		if (type.equals("cookie")) { 
			return 1.11f; 
			} 
		else if (type.equals("pie")) { 
			return 5.5f; }
		else return 0;
		} 

	public static int getAmount(String type) throws Exception { 
		// 获得产品数量 
		if (type.equals("cookie")) { 
			return 10; } 
		else { 
			return 20; }
		} 

	public static float calculate() throws Exception{ 
		float price = getPrice("cookie"); 
		int amount = getAmount("cookie"); 
		return price * amount; 
		} 
	
		public static void main(String[] args) throws Exception {
			calculate();
		}
	}