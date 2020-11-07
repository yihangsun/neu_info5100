package assignment7;
import java.util.concurrent.atomic.AtomicLong;

class myThread extends Thread {
	   private AtomicLong sum;
	   private int start;
	   private int end;
	   private int[] arr;

	   public myThread(int start, int end, int[] arr) {
	     this.sum = new AtomicLong();
	     this.start = start;
	     this.end = end;
	     this.arr = arr;
	   }

	   public void run() {
	     for (int i = start; i < end; i++) {
	      sum.addAndGet(arr[i]);
	     }
	   }

	   public long getSum() {
	     return sum.get();
	   }
}

