package problem2;

public class CounterThreadTester {
	public static void main(String[] args) {
		Thread t1 = new Thread(new CounterThread(2, false), "t1");
		Thread t2 = new Thread(new CounterThread(3, false), "t2");
		Thread t3 = new Thread(new CounterThread(4, true), "t3");
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
	}
}

