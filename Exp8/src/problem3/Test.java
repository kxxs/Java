package problem3;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> data=new ArrayList<String>();
		new Producer(data,20).start();
		new Consumer(data,10).start();
		new Consumer(data,10).start();
	}
}
