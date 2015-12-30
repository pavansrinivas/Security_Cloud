/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */


import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxAccountInfo;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author greg
 */
public class Test_204631946 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Testing...");

        String userLocale = Locale.getDefault().toString();
        DbxRequestConfig requestConfig = new DbxRequestConfig("test_204631946", userLocale);
        DbxClient dbxClient = new DbxClient(requestConfig, "Ob64L9zS9SAAAAAAAAAAdZX6KUh_XWI4OoYcGTROJJx5Z9eCFlc4p6NjS6gF8hUZ");

        try {
            DbxEntry.File.Folder. md = dbxClient.files.createFolder("/test_java_createFolder_" + Integer.toString(new Random().nextInt(1000000)));
            System.out.print(md);
        }
        catch (DbxException ex) {
            System.err.println("Error making API call: " + ex.getMessage());
            System.exit(1); return;
        }


    }

}
