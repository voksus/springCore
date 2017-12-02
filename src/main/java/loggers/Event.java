package loggers;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    private static int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date) {
        ++id;
        this.date = date;
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "loggers.Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }

}