package problem4;

import java.util.ArrayList;

public class Producer extends Thread{
	WareHouse data=new WareHouse() ;
	int speed;

	public Producer(WareHouse data, int speed) {
		this.speed = speed;
		this.data = data;
	}

	public void run() {
		synchronized (data) {
			for (int i = 1; i <= speed; i++) {
				String message = "String-" + i;
				System.out.println(this.getName()+" produces:" + message);
				data.addCargo(message);
			}
		}
	}
}
