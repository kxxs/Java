package problem1;

class Thread1 extends Thread {
	public void run() {
		try {
			for (int i = 1; i < 1001; i++,Thread.sleep(1))
				System.out.println("Thread1:" + i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 1; i < 1001; i++,Thread.sleep(1))
				System.out.println("Thread2:" + i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Counter {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		new Thread(thread2).setPriority(8);
		thread1.start();
		new Thread(thread2).start();
	}
}

//结论：一般是优先级高的先执行