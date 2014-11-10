/**
 * @author Kirillov Kirill
 *         11-306
 */
public class MyThread2 implements Runnable {
    Thread t;

    public MyThread2(){
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        MyThread2 myThread21 = new MyThread2();
    }
}
