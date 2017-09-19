package drawing.domain;

import java.util.Properties;

public interface IPersistencyMediator {
    Drawing load(String name);
    boolean save(Drawing drawing);
    boolean init(Properties props);
}
