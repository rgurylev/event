package event;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EventObject;

/**
 * Created by roman on 02.02.16.
 */
public abstract class ApplicationEvent extends EventObject {

    private static final Logger log = LogManager.getRootLogger();;
    Object source;

    private ApplicationEvent() {
        super(null);
    }

    public ApplicationEvent(Object source ) {

        super(source);
        this.source = source;
        EventsDispatcher.getInstance().fireEvent(this);
    }



}
