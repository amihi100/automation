import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void overload() throws InterruptedException {
		int n = 10;
		MondayThread[] threads = new MondayThread[n];
		for (int i = 0; i < n; i++) {
		     Thread.sleep(3000);
			threads[i] = new MondayThread();
		}
		for (int i = 0; i < n; i++) {
		     Thread.sleep(5000);
			threads[i].start();
		}
	}

	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {

		overload();
		// בדיקת עומסים
		// TODO Auto-generated method stub
		// Monday x= null;
		// x.pangoAutomatedTest();

	}

}
