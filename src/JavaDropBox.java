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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import com.dropbox.core.DbxAccountInfo;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

public class JavaDropBox {

	private static final String DROP_BOX_APP_KEY = "h7jmnwvq2ba5gie";
	private static final String DROP_BOX_APP_SECRET = "l5zqjeqpfr27hfi";
	DbxClient dbxClient;
        //dbxClient.disableAccessToken();

	public DbxClient authDropbox(String dropBoxAppKey, String dropBoxAppSecret)
			throws IOException, DbxException {
		DbxAppInfo dbxAppInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
		DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
				"JavaDropboxTutorial/1.0", Locale.getDefault().toString());
		DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(
				dbxRequestConfig, dbxAppInfo);
		String authorizeUrl = dbxWebAuthNoRedirect.start();
		System.out.println("1. Authorize: Go to URL and click Allow : "
				+ authorizeUrl);
		System.out
				.println("2. Auth Code: Copy authorization code and input here ");
		String dropboxAuthCode = new BufferedReader(new InputStreamReader(
				System.in)).readLine().trim();
		DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
		String authAccessToken = authFinish.accessToken;
                String authAccessToken1="Ob64L9zS9SAAAAAAAAAAaPHooNaLp_O06y967eErX2DCjI4gLhfvMK8_8KX0kIWM";
		dbxClient = new DbxClient(dbxRequestConfig, authAccessToken1);
		System.out.println("Dropbox Account Name: "
				+ dbxClient.getAccountInfo().displayName);

		return dbxClient;
	}

	/* returns Dropbox size in GB */
	public long getDropboxSize() throws DbxException {
		long dropboxSize = 0;
		DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
		// in GB :)
		dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
		return dropboxSize;
	}

	public void uploadToDropbox(String fileName) throws DbxException,
			IOException {
                //dbxClient.disableAccessToken();
                
		File inputFile = new File(fileName);
                System.out.println(inputFile.getAbsolutePath());
		try (FileInputStream fis = new FileInputStream(inputFile)) {
                    System.out.println(fis);
			DbxEntry.File uploadedFile = dbxClient.uploadFile("/Pavan_CS/"+ fileName,
					DbxWriteMode.add(), inputFile.length(), fis);
                        System.out.println("1234"+uploadedFile.path);
                        
                        System.out.println("01.Pavan"+uploadedFile);
			String sharedUrl = dbxClient.createShareableUrl("/Pavan_CS" + fileName);
                        System.out.println("1.pavan"+sharedUrl);
			System.out.println("Uploaded: " + uploadedFile.toString() + " URL "
					+ sharedUrl);
		}
                catch(Exception ex)
                {
                    System.out.println("THe file is not found -->Pavan "+ex);
                }
	}

	public void createFolder(String folderName) throws DbxException {
		dbxClient.createFolder("/" + folderName);
	}

	public void listDropboxFolders(String folderPath) throws DbxException {
		DbxEntry.WithChildren listing = dbxClient
				.getMetadataWithChildren(folderPath);
		System.out.println("Files List:");
		for (DbxEntry child : listing.children) {
			System.out.println("	" + child.name + ": " + child.toString());
		}
	}

	public void downloadFromDropbox(String fileName) throws DbxException,
			IOException {
		try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
			DbxEntry.File downloadedFile = dbxClient.getFile("/" + fileName,
					null, outputStream);
			System.out.println("Metadata: " + downloadedFile.toString());
		}
	}

	public static void main(String[] args) throws IOException, DbxException {
                 
		JavaDropBox javaDropbox = new JavaDropBox();
		javaDropbox.authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
		System.out.println("Dropbox Size: " + javaDropbox.getDropboxSize()
				+ " GB");
		//javaDropbox.uploadToDropbox("happy.png");
                javaDropbox.uploadToDropbox("security-banner.jpg");
		javaDropbox.createFolder("Pavan_CS01");
		javaDropbox.listDropboxFolders("/");
		javaDropbox.downloadFromDropbox("happy.png");

	}

}

