package problem3;

import java.util.ArrayList;

public class Producer extends Thread{
	ArrayList<String> data=new ArrayList<String>() ;
	int speed;

	public Producer(ArrayList<String> data, int speed) {
		this.speed = speed;
		this.data = data;
	}

	public void run() {
		synchronized (data) {
			for (int i = 1; i <= speed; i++) {
				String message = "String-" + i;
				System.out.println(this.getName()+" produces:" + message);
				data.add(message);
			}
		}
	}
}
