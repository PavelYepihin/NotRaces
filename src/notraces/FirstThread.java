package notraces;

/**
 * Created by Администратор on 23.01.2017.
 */
public class FirstThread implements Runnable {
    private SomeArray someArray;
    public Thread t;

    public FirstThread(SomeArray someArray) {
        this.someArray = someArray;
        t = new Thread(this, "FirstThread");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            someArray.write();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.getName() + " завершил работу");
    }
}
