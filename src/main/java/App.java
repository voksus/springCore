import beans.Client;
import loggers.ConsoleEventLogger;
import loggers.Event;
import loggers.FileEventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, FileEventLogger fileEventLogger) {}

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

//        app.client = new beans.Client("1", "Voksus Burton");
//        app.eventLogger = new loggers.ConsoleEventLogger();

        app.logEvent((Event) ctx.getBean("event"), "Some event for user 1");
        app.logEvent((Event) ctx.getBean("event"), "Some event for user 2");
        ctx.close();
    }

    private void logEvent(Event event, String msg) {
        if (event == null || msg == null) return;
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(event);
    }
}