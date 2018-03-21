package problem2;

public class CounterThread implements Runnable {
	public static Object lock = new Object();
	int num = 2;
	boolean isNotifier = false;

	public CounterThread(int num, boolean isNotifier) {
		this.num = num;
		this.isNotifier = isNotifier;
	}

	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				if (i == num) {
					if (isNotifier) {
						lock.notifyAll();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}