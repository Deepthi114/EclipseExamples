class Mahesh extends Thread {
	public void run() {
		for (int i = 10; i <= 15; i++) {
			System.out.println("Mahee I=" + i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Deepu extends Thread // start() run()
{
	public void run() {
		for (int i = 10; i <= 15; i++) {
			System.out.println("Deepu I=" + i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class MultiDemo {

	public static void main(String[] args) {
		Mahesh m = new Mahesh();
		Deepu d = new Deepu();
		m.start();
		d.start();

	}

}
