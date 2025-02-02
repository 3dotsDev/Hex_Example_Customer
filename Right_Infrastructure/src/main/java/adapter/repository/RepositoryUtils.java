package adapter.repository;

import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryUtils {
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static int getPrimaryKey() {
        return atomicInt.incrementAndGet();
    }
}
