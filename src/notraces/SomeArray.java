package notraces;

import java.util.Random;

/**
 * Created by Администратор on 23.01.2017.
 */

public class SomeArray {
    private int arr[];
    private static final Object mutex = new Object();
    private Random r;

    public SomeArray() {
        arr = new int[10];
        r = new Random();
    }

    public void write() {
        synchronized (mutex) {
            System.out.print("Записано: ");
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + (arr[i] = r.nextInt(100)));
            }
            System.out.println("");
        }
    }

    public void read() {
        synchronized (mutex) {
            System.out.print("Прочитано: ");
            for (int x : arr) {
                System.out.print(" " + x);
            }
            System.out.println("");
        }
    }
}

