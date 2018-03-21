package problem3;

import java.util.ArrayList;

public class Consumer extends Thread {

	ArrayList<String> data = new ArrayList<String>();
	int speed;

	public Consumer(ArrayList<String> data, int speed) {
		this.speed = speed;
		this.data = data;
	}

	public void run() {
		synchronized (data) {
				if (data.size() == 0)
					try {
						data.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				while (data.size() > 0 && speed>0) {
					System.out.println(this.getName() + " consumes:" + data.get(0));
					data.remove(0);
					this.speed--;
				}
			}
		}
	}
