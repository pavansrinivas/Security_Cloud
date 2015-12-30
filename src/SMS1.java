/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
public class SMS1 {
    String message;
    
    static String se=new String();
    static String sop1=new String();
    static String m1=new String();
     static String som1=new String();
    
    public void getphnumber(String sop)
    {
        sop1=sop;
        System.out.println("3."+sop1);
    }
    public String getmessage(String som)
    {
        sop1=som;
        return sop1;
       // System.out.println("3."+som1);
    }
    
    
    public void sendsms(String so)
    {
        GenerateRandomNumbers gre1=new GenerateRandomNumbers();
        
String user = "pa1pavan";

// Replace with your API KEY (We have sent API KEY on activation email, also available on panel)
String apikey = "q3yBlIjuVSJc0GC8dwV8";

// Replace with the destination mobile Number to which you want to send sms
//String mobile = SMS.sop1;
String mobile = "9177195275";
System.out.println("4."+mobile);

// Replace if you have your own Sender ID, else donot change
String senderid = "MYTEXT";
gre1.random1();
// Replace with your Message content
message = gre1.s1;
m1=this.message;
MobileCode mekl=new MobileCode();
mekl.getcode(m1);



System.out.println("6."+message);

// For Plain Text, use "txt" ; for Unicode symbols or regional Languages like hindi/tamil/kannada use "uni"
String type="txt";

//Prepare Url
HttpURLConnection myURLConnection=null;
URL myURL=null;
BufferedReader reader=null;

//encoding message 
String encoded_message=URLEncoder.encode(m1);

//Send SMS API
String mainUrl="http://smshorizon.co.in/api/sendsms.php?";

//Prepare parameter string 
StringBuilder sbPostData= new StringBuilder(mainUrl);
sbPostData.append("user=").append(user); 
sbPostData.append("&apikey=").append(apikey);
sbPostData.append("&message=").append(encoded_message);
sbPostData.append("&mobile=").append(mobile);
sbPostData.append("&senderid=").append(senderid);
sbPostData.append("&type=").append(type);

//final string
mainUrl = sbPostData.toString();
try
{
    //prepare connection
    myURL = new URL(mainUrl);
    myURLConnection = (HttpURLConnection) myURL.openConnection();
    myURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
    myURLConnection.connect();
    reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
    //reading response 
    String response;
    while ((response = reader.readLine()) != null) 
    //print response 
    System.out.println("RESPOSNE NUMBER"+response);
    
    //finally close connection
    reader.close();
} 
catch (IOException e) 
{ 
	e.printStackTrace();
} 
    }


    public static void main(String [] args)
    {
    // Replace with your username
        Registeration regp=new Registeration();
        se=regp.ph_num;
        System.out.println("PHNUMBER RETRIVED"+se);
        
        SMS sw=new SMS();
        sw.getphnumber(se);
        sw.sendsms(se);
        
        
        
    }
        
}
