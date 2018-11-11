package testevent;

import event.ApplicationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyEvent extends ApplicationEvent {
    private static final Logger log = LogManager.getRootLogger();;
    Object source;
    String name;

    MyEvent(Object source, String name) {
        super(source);
        this.source = source;
        this.name = name;
    }

    public static MyEvent.MyEventBuilder builder() {
        return new MyEvent.MyEventBuilder();
    }

    public static class MyEventBuilder {
        private Object source;
        private String name ;

        MyEventBuilder() {
        }

        public MyEvent.MyEventBuilder source(Object source) {
            this.source = source;
            return this;
        }

        public MyEvent.MyEventBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MyEvent build() {
            return new MyEvent(this.source, this.name);
        }

        public String toString() {
            return "MyEvent.MyEventBuilder(source=" + this.source + ", name=" + this.name + ")";
        }
    }
}
