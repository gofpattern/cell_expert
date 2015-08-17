package bookmark.app;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IBookMark
 */
public class IBookMark extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IBookMark() {
        // TODO Auto-generated constructor stub
    	System.out.println("in Construtor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in Get");
		String userHomePath = System.getProperty("user.home");
		Enumeration listParam = request.getParameterNames();
		PrintWriter out = response.getWriter();
		while (listParam.hasMoreElements()) {
		      String key = (String) listParam.nextElement();
		      String path = request.getParameter(key);
		      System.out.println(key + " -- "+path);
		      
		      
		        File userHome = new File(userHomePath);
		        // uses the corect path separator for the OS
		        String folder = path;
		        File dir = new File(userHome,folder);
		        Desktop.getDesktop().open(dir);
		    }
		
    	out.println(listParam);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post");
		PrintWriter out = response.getWriter();
    	out.println("Hello World");
	}

}
