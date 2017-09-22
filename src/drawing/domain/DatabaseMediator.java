package drawing.domain;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements IPersistencyMediator{

    // de connectie, user en pass van de database komen in het prop object
    private Properties prop;
    private Connection con;


    private void closeConnection() {
        this.con = null;
    }

    private void initConnection() {
        try {
            String url = "jdbc:mysql://studmysql01.fhict.local/dbi364775";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection(url, "dbi364775", "Userpass1!");
        } catch (SQLException var2) {
            var2.printStackTrace();
        } catch (IllegalAccessException var3) {
            var3.printStackTrace();
        } catch (InstantiationException var4) {
            var4.printStackTrace();
        } catch (ClassNotFoundException var5) {
            var5.printStackTrace();
        }

    }

    @Override
    public Drawing load(String name) {
        Drawing drawing = null;
        try {
            this.initConnection();
            Statement myStmt = this.con.createStatement();
            String sql = "select * from drawing where name = ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet myRs = ps.executeQuery();
            //todo dit even aanpassen
            //File file = new File("/Users/gebruiker/Documents/FHICT/S3/JCC/" + name + ".ser");
            //FileOutputStream output = new FileOutputStream(file);
            
            if (myRs.next()) {
                byte[] input = myRs.getBytes(2);
                ObjectInputStream objectIn = new ObjectInputStream(new ByteArrayInputStream(input));
                drawing = (Drawing) objectIn.readObject();
            }
            myRs.close();
            myStmt.close();
        } catch (IOException | SQLException var10) {
            var10.printStackTrace();
            this.closeConnection();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return drawing;

    }

    @Override
    public boolean save(Drawing drawing) {
        try{
        this.initConnection();
        //SeralisationMediator s = new SeralisationMediator();
        //s.save(drawing);
        String sql = "INSERT INTO drawing(name, drawing) VALUES (?,?);";
        PreparedStatement myStmt = this.con.prepareStatement(sql);
        //File file = new File("/Users/gebruiker/Documents/FHICT/S3/JCC/" + drawing.getName() + ".ser");
        //FileInputStream input = new FileInputStream(file);
        myStmt.setString(1, drawing.getName());
        myStmt.setObject(2, drawing);
        myStmt.executeUpdate();
        this.closeConnection();
        return true;
        }
        catch ( SQLException var7) {
            var7.printStackTrace();
            this.closeConnection();
            return false;
        }
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}


