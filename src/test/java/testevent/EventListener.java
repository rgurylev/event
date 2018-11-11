package testevent;

import event.ApplicationEvent;
import event.ApplicationEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventListener implements ApplicationEventListener {

    private static final Logger log = LogManager.getRootLogger();;
    private String name;
    private Integer eventCount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventListener() {}

    public EventListener(String name) {
        this.name = name;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    @Override
    public void notify(ApplicationEvent e) {
        this.eventCount++;
        log.info("Слушатель " + getName() +" получил сообщение от объекта:" + e.getSource().getClass());
    }

    public String info() {
        String s;
        s = "Объект name:" + this.name + " (hash=" + this.hashCode() + ") / Class name: " + this.getClass().getName() +
                " (hash=" + this.getClass().hashCode() + ")";
        return s;
    }
}
