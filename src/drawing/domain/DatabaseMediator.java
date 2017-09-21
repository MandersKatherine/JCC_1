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
            String url = "jdbc:mysql://localhost:3306/tekenapplicatie";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection(url, "student", "student");
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

        try {
            this.initConnection();
            Statement myStmt = this.con.createStatement();
            String sql = "select file from drawing where `name` like ?";
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet myRs = ps.executeQuery();
            File file = new File("D:\\Fontys\\Semester3\\JCC\\SerializationFiles\\" + name + ".ser");
            FileOutputStream output = new FileOutputStream(file);
            if (myRs.next()) {
                InputStream input = myRs.getBinaryStream("file");
                byte[] buffer = new byte[1024];

                while(input.read(buffer) > 0) {
                    output.write(buffer);
                }
            }
        } catch (IOException | SQLException var10) {
            var10.printStackTrace();
            this.closeConnection();
            return null;
        }

        SeralisationMediator s = new SeralisationMediator();
        Drawing drawing = s.load(name);
        this.closeConnection();
        return drawing;

    }

    @Override
    public boolean save(Drawing drawing) {
        try{
        this.initConnection();
        SeralisationMediator s = new SeralisationMediator();
        s.save(drawing);
        String sql = "INSERT INTO drawing(name, file) VALUES (?,?);";
        PreparedStatement myStmt = this.con.prepareStatement(sql);
        File file = new File("D:\\Fontys\\Semester3\\JCC\\SerializationFiles\\" + drawing.getName() + ".ser");
        FileInputStream input = new FileInputStream(file);
        myStmt.setString(1, drawing.getName());
        myStmt.setBinaryStream(2, input);
        myStmt.executeUpdate();
        this.closeConnection();
        return true;
        }
        catch (FileNotFoundException | SQLException var7) {
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


