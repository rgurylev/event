package testevent;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by roman on 03.02.16.
 */
public class EventSource implements Runnable  {

    private static final Logger log = LogManager.getRootLogger();;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventSource() { }

    public EventSource(String name) {
        this.name = name;
    }

    public String info() {
        String s;
        s = "Объект name:" + this.name + " (hash=" + this.hashCode() + ") / Class name: " + this.getClass().getName() +
                " (hash=" + this.getClass().hashCode() + ")";
        return s;
    }


    @Override
    public void run() {
        /*
        SourceD d = new SourceD(this.name);
        log.info("Cоздали объект " + d.info());
        */
    }
}
