/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
//BLOB_FILE INSERTION TO DATABASE
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**+
 *
 * @author pavan
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class filesavingtodbms5 {
     Registeration reg=new Registeration();
    static String usr=new String();
    public void fv(String str)
    {
        usr=str;
        System.out.print("usrname Saved   "+usr);
    
    }
    public void filesave(String name){
        String url = "jdbc:derby://localhost:1527/photodb";
        String user = "pavan";
        String password = "pa1dperfect";
        
        //Acess_modifyFiles1 amf2=new Acess_modifyFiles1();
        //name="D:\\java1.gif";
       System.out.print(usr);
      
      try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            InputStream inputStream = new FileInputStream(new File(name));
           //String username=reg.s11;
           if(usr==null)
           {
               System.out.println("String is null");
           }
    System.out.println("1 "+usr);
    
        String sql = "update CS_REGISTER set BLOB_5 = ? where usr_name = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setBlob(1, inputStream);
            statement.setString(2,usr);
           // InputStream inputStream = new FileInputStream(new File(name));
            //statement.setBlob(1, inputStream);
            int row = statement.executeUpdate();
            System.out.print("rn"+row);
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
           
          conn.close();
    }
   
         catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(filesavingtodbms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public static void main(String[] args) throws ClassNotFoundException {
        
        
      // Acess_modifyFiles1 amf1=new Acess_modifyFiles1();
        Select_number seno=new Select_number();
       filesavingtodbms5 fstb=new filesavingtodbms5();
        fstb.filesave(seno.fileselectedpath);
        
    }
}