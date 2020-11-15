package assignment8_maxNum;

public class MaxValue {
	private int[] array;
	
	public MaxValue(int[] array) {
		this.array = array;
	}
	
	public int findMax() {
		int quarter = array.length / 4;
		
		MyThread t1 = new MyThread(array, 0, quarter);
		MyThread t2 = new MyThread(array, quarter, quarter * 2);
		MyThread t3 = new MyThread(array, quarter * 2, quarter * 3);
		MyThread t4 = new MyThread(array, quarter * 3, array.length);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		return Math.max(Math.max(t1.getCurmax(), t2.getCurmax()), Math.max(t3.getCurmax(), t4.getCurmax()));
	}
	
	class MyThread extends Thread {
		int curmax;
		int[] array;
		int min;
		int max;
		
		public MyThread(int[] array, int min, int max) {
			this.array = array;
			this.min = min;
			this.max = max;
			curmax = Integer.MIN_VALUE;
		}
		
		@Override
		public void run() {
			for (int i = min; i < max; i++) {
				curmax = Math.max(curmax, array[i]);
			}
		}
		
		public int getCurmax() {
			return curmax;
		}
	}
}
