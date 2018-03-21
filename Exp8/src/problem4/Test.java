package problem4;


public class Test {
	public static void main(String[] args) {
		WareHouse data=new WareHouse();
		new Producer(data,20).start();
		new Consumer(data,10).start();
		new Consumer(data,10).start();
	}
}

//和第三题输出一致