
public class MondayThread  extends Thread {

	public void run() {
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        try {
        	Monday x=  new Monday();
			x.pangoAutomatedTest();
            //Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }
}
