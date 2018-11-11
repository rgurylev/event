package testevent;

import event.EventsDispatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class testMain extends Assert {

    private static final Logger log = LogManager.getRootLogger();;

    @Before
    public void setup () {
//        java.util.Locale.setDefault(new java.util.Locale("ru", "RU"));

    }

    @Test
    public void testMain() throws Exception {

        EventSourceC sourceC =  new EventSourceC("Red");
        log.info("Создали иcточник N1: " + sourceC.info());

        EventSourceD sourceD = new EventSourceD("Green");
        log.info("Создали иcточник N2 : " + sourceD.info());

        EventListenerA listenerA = new EventListenerA("Black");
        log.info("Создали слушателя N1: " + listenerA.info());

        EventListenerB listenerB =  new EventListenerB("White");
        log.info("Создали слушателя N2: " + listenerB.info());

        EventsDispatcher.getInstance().registerListener(listenerA, EventSourceC.class);
        EventsDispatcher.getInstance().registerListener(listenerB, EventSourceD.class);
        log.info("==========================================================================");

        MyEvent.builder().source(sourceC).build();
        MyEvent.builder().source(sourceC).build();
        MyEvent.builder().source(sourceC).build();
        MyEvent.builder().source(sourceD).build();
        MyEvent.builder().source(sourceD).build();

        assertTrue(listenerA.getEventCount()==3);
        assertTrue(listenerB.getEventCount()==2);

    }

}