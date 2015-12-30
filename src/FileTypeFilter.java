/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavan
 */
import java.io.File;
import javax.swing.filechooser.*;
public class FileTypeFilter extends FileFilter{
private final String extension;
private final String description;
public FileTypeFilter(String extension,String description){
    this.description=description;
    this.extension=extension;
}
    @Override
    public boolean accept(File f) {
       // throw new UnsupportedOperationException("Not supported yet."); 
        if(f.isDirectory()){
            return true;
        }
           return f.getName().endsWith(extension);
    }

    @Override
    public String getDescription() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return description+String.format(" (*%s)",extension);
    }
    
}
