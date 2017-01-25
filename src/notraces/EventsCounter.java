package notraces;

/**
 * Created by Администратор on 25.01.2017.
 */

public class EventsCounter {
    private static EventsCounter ourInstance;

    private EventsCounter() {

    }

    public static EventsCounter getInstance() {
        if (ourInstance == null) {
            synchronized (EventsCounter.class) {
                if (ourInstance == null) {
                    ourInstance = new EventsCounter();
                }
            }
        }
        return ourInstance;
    }
}
