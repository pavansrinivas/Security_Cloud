
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
public class databaseConnection {
    private int photo;
 
    public void loadDriver() {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            }
            catch (Exception ex) {
           System.out.println("not Connected, com.mysql.jdbc.Driver class not found");
            }
    }
 
    public void connect() throws IOException, SQLException {
        Connection conn = null;
 
    try {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/photodb","pavan","pa1dperfect");
        System.out.println("Connected");
 
        Statement stmt = null;
        ResultSet rs = null;
        stmt =  (Statement) conn.createStatement();
        rs =    (ResultSet) stmt.executeQuery("SELECT BLOB_1 FROM CS_REGISTER");
 
        while (rs.next()) {
            Blob ph = rs.getBlob("photo");

        System.out.println(ph);
 
        InputStream in = ph.getBinaryStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
 
        int length = (int) ph.length();
        int bufferSize = 1024;
         
        byte[] buffer = new byte[bufferSize];
 
        while ((length = in.read(buffer)) != -1) {
            System.out.println("writing " + length + " bytes");
            out.write(buffer, 0, length);
        }
 
        in.close();
        }
                }
 
    catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
    }
}
}