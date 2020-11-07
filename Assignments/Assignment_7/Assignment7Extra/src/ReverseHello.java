
public class ReverseHello extends Thread {
	private int num;
	
	public ReverseHello(int num) {
		this.num = num;
	}
	
	public void run() {
		System.out.println("Hello from Thread " + num + "！");
	}
	
	public static void main(String[] args) {
		for (int i = 50; i > 0; i--) {
			ReverseHello rh = new ReverseHello(i);
			rh.start();
			try {
				rh.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}