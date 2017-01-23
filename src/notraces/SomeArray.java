package notraces;

import java.util.Random;

/**
 * Created by Администратор on 23.01.2017.
 */

public class SomeArray {
    private int arr[];
    private boolean writeFlag;
    private Random r;

    public SomeArray() {
        arr = new int[10];
        r = new Random();
        writeFlag = false;
    }

    synchronized public void write() {
        while (writeFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Записано: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (arr[i] = r.nextInt(100)));
        }
        writeFlag = true;
        System.out.println("");
        notify();
    }

    synchronized public void read() {
        while (!writeFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Прочитано: ");
        for (int x : arr) {
            System.out.print(" " + x);
        }
        writeFlag = false;
        System.out.println("");
        notify();
    }
}
