package event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by roman on 02.02.16.
 */
public class EventsDispatcher {

        private static final Logger log = LogManager.getRootLogger();;
        private static EventsDispatcher eventsDispatcher;
        private Map<Integer, List<ApplicationEventListener>> listeners;

        public static void registerListener (ApplicationEventListener listener, Class source) {
            if  (eventsDispatcher == null) {
                getInstance();
            }

            Integer key = source.hashCode();
            if (eventsDispatcher.listeners.containsKey(key)) {
                eventsDispatcher.listeners.get(key).add(listener);
            }
            else{
                CopyOnWriteArrayList list = new CopyOnWriteArrayList();
                list.add(listener);
                eventsDispatcher.listeners.put(key, list);
            }
            log.debug(listener.getClass().getName() + " слушает " + source.getName());
            log.debug("зарегистрировано слушателей: " + eventsDispatcher.listeners.size());

        }

        public static void fireEvent (ApplicationEvent e) {
            Integer key = e.getSource().getClass().hashCode();
            List<ApplicationEventListener> listeners = new CopyOnWriteArrayList<ApplicationEventListener>();
            listeners = eventsDispatcher.listeners.get(key);
            for (ApplicationEventListener listener: listeners ){
                listener.notify(e);
            }
        }

        public static synchronized EventsDispatcher getInstance() {
            if (eventsDispatcher == null) {
                eventsDispatcher = new EventsDispatcher();
                eventsDispatcher.listeners = new ConcurrentHashMap<Integer, List<ApplicationEventListener> >();
                log.debug("Создали экземпляр EventsDispatcher");
            }
            return eventsDispatcher;
        }

        private EventsDispatcher() {}

        public String listenersInfo(){
            String s = "";
            for (Map.Entry<Integer, List<ApplicationEventListener>> entry : listeners.entrySet()) {
                    s = s + "key: " + entry.getKey() + " listeners: [";
                    for (ApplicationEventListener listener: entry.getValue()){
                        s = s + listener.getClass().getName() + ", ";
                    }
                    s = s + "]" +"\n";
            }
            return s;
        }
}
