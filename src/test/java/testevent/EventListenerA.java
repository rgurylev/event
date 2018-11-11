package testevent;

import event.ApplicationEvent;
import event.ApplicationEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by roman on 03.02.16.
 */
public class EventListenerA extends EventListener {

    private static final Logger log = LogManager.getRootLogger();;
    public EventListenerA(String name) {
        super(name);
    }

    /*
    public EventListenerA(String name) {
        super(name) = name;
    }
    */


    @Override
    public void notify(ApplicationEvent e) {
        //log.info("Слушатель " + getName() +" получил сообщение от объекта:" + e.getSource().getClass());
        super.notify(e);
    }

    /*
    public String info() {
        String s;
        s = "Объект name:" + this.name + " (hash=" + this.hashCode() + ") / Class name: " + this.getClass().getName() +
                " (hash=" + this.getClass().hashCode() + ")";
        return s;
    }
    */
}
