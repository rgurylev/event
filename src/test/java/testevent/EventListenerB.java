package testevent;

import event.ApplicationEvent;
import event.ApplicationEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by roman on 03.02.16.
 */
public class EventListenerB extends EventListener {

    private static final Logger log = LogManager.getRootLogger();;
    public EventListenerB(String name) {
        super(name);
    }

    @Override
    public void notify(ApplicationEvent e) {
        super.notify(e);
        //log.info("Слушатель " + getName() +" получил сообщение от объекта:" + e.getSource().getClass());
    }

}
