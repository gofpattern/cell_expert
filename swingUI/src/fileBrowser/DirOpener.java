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
	        Desktop.getDesktop().open(dir);
	    }
	}


