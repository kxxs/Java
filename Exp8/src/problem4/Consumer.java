package problem4;

public class Consumer extends Thread {

	WareHouse data = new WareHouse();
	int speed;

	public Consumer(WareHouse data, int speed) {
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
				while (data.size() > 0 && speed > 0) {
					System.out.println(this.getName() + " consumes:" + data.getCargo(0));
					data.removeCargo(0);
					speed--;
				}
			}
		}
	}
