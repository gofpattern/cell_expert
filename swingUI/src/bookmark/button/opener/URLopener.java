package bookmark.button.opener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class URLopener {
	
	public static void folderOpener(String url) throws IOException{

        String userHomePath = System.getProperty("user.home");
        File userHome = new File(userHomePath);
        // uses the corect path separator for the OS
        String path  = url;
        File folder = new File(url);
        try
        {
        Desktop.getDesktop().open(folder);
        }
        
       catch(IllegalArgumentException e)
       {
    	  System.out.println("Warning: "+ e.getMessage());
    	  
       }
        finally{
        	
        }
       // Runtime.getRuntime().exec("cmd.exe /c start");
    
	}

	public static void deleteUrl(String url) {
		
		
	}

}
