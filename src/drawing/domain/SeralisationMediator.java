package drawing.domain;

import java.io.*;
import java.util.Properties;

public class SeralisationMediator implements IPersistencyMediator , java.io.Serializable{
    /*
    Deze klasse schrijft een geseraliseerd object naar een klasse toe.
     */

    // todo de naam van een file kan worden geinstantieerd via het prop object????
    public Properties prop;

    @Override
    public Drawing load(String name) {
        try {

            File f = new File("/Users/gebruiker/Documents/FHICT/S3/JCC/" + name + ".ser");
            FileInputStream fileIn = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Drawing d = (Drawing)in.readObject();
            return d;
        }
        catch(Exception i) {
            i.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Drawing drawing) {
        try {
            //todo de prop.name iets geenidee
            File f = new File("/Users/gebruiker/Documents/FHICT/S3/JCC/" + drawing.getName() + ".ser");
            FileOutputStream fileOut = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(drawing);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
            return true;
        }
        catch(IOException i) {
            i.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
