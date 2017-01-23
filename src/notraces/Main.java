package notraces;

/**
 * Created by Администратор on 23.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        SomeArray someArray = new SomeArray();
        FirstThread thread1 = new FirstThread(someArray);
        SecondThread thread2 = new SecondThread(someArray);

        try {
            thread1.t.join();
            thread2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный поток завершил работу");
    }
}
