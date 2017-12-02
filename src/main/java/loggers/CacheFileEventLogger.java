package loggers;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() >= cacheSize) {
            for (Event ev : cache) {
                super.logEvent(ev);
            }
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            for (Event event : cache) {
                super.logEvent(event);
            }
        }
    }
}