/**
 * @author Kirillov Kirill
 *         11-306
 */
public class MyThread extends Thread {
    public MyThread(String s) {
        setName(s);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(this.getName() + " : " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            this.yield();
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread("t1");
        MyThread t1 = new MyThread("t2");
        t.start();
        t1.start();
    }
}
