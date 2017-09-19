package drawing.domain;

import java.util.Properties;

public class DatabaseMediator implements IPersistencyMediator{

    // de connectie, user en pass van de database komen in het prop object
    private Properties prop;

    @Override
    public Drawing load(String name) {

        //niet succesvol?
        return null;

    }

    @Override
    public boolean save(Drawing drawing) {
        return true;
    }

    @Override
    public boolean init(Properties props) {
        return true;
    }
}
