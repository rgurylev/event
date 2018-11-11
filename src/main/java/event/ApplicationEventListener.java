package event;

import java.util.EventListener;

/**
 * Created by roman on 02.02.16.
 */
public interface ApplicationEventListener  extends EventListener {
    void notify (ApplicationEvent e);
}
