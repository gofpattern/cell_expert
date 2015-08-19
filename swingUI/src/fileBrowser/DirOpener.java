package fileBrowser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class DirOpener {
	

	    public static void main(String[] args) throws IOException {
	        String userHomePath = System.getProperty("user.home");
	        File userHome = new File(userHomePath);
	        // uses the corect path separator for the OS
	        String folder = "\\NCSF-eclipse\\NCSF";
	        File dir = new File(userHome,folder);
	        try
	        {
	        Desktop.getDesktop().open(dir);
	        }
	        
	       catch(IllegalArgumentException e)
	       {
	    	  System.out.println("Warning: "+ e.getMessage());
	    	  
	       }
	        finally{
	        	
	        }
	        Runtime.getRuntime().exec("cmd.exe /c start");
	    }
	}


