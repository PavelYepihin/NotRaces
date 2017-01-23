package notraces;

/**
 * Created by Администратор on 23.01.2017.
 */
public class SecondThread implements Runnable {
    private SomeArray someArray;
    public Thread t;

    public SecondThread(SomeArray someArray) {
        this.someArray = someArray;
        t = new Thread(this, "SecondThread");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            someArray.read();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.getName() + " завершил работу");
    }
}
