package loggers;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(fileName), event.toString(), "UTF-8", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (file.canWrite()) {
            throw new RuntimeException("CANNOT WRITE TO FILE " + fileName);
        }
    }

}