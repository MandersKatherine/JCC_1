package drawing.domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class SeralisationMediator implements IPersistencyMediator , java.io.Serializable{
    /*
    Deze klasse schrijft een geseraliseerd object naar een klasse toe.
     */

    // todo de naam van een file kan worden geinstantieerd via het prop object????
    public Properties prop;

    @Override
    public Drawing load(String name) {
        //todo returned null wanneer deze niet succesvol wordt uitgevoerd
        return null;

    }

    @Override
    public boolean save(Drawing drawing) {
        //todo het drawing object moet het gehele tekenveld zijn
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/drawing.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(drawing);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/drawing.ser");
            return true;
        }
        catch(IOException i) {
            i.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean init(Properties props) {
        return true;
    }
}
