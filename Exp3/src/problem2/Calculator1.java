package problem2;
public class Calculator1 { 
	public float getPrice(String type) throws Exception {
		// 获得产品单价 
		if (type.equals("cookie")) { 
			return 1.11f; 
			} 
		else if (type.equals("pie")) { 
			return 5.5f; }
		else return 0;
		} 

	public int getAmount(String type) throws Exception { 
		// 获得产品数量 
		if (type.equals("cookie")) { 
			return 10; } 
		else { 
			return 20; }
		} 

	public  float calculate() { 
		try {
		float price = getPrice("cookie"); 
		int amount = getAmount("cookie"); 
		return price * amount; 
		} 
			catch (Exception e)
			{
				e.printStackTrace();
				return -1;
			}
		}
	
		public static void main(String[] args) {
			Calculator1 a=new Calculator1();
			float x=a.calculate();
			System.out.println(x);
		}
	}