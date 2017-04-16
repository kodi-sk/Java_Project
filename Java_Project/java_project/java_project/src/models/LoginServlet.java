package models;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servelet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath = request.getServletPath();
		String getURL = "/" + userPath + ".jsp";
		if(userPath.equals("/x")){
			try {
				user Studentuser = new user();
			     Studentuser.setName(request.getParameter("username"));
			     Studentuser.setPass(request.getParameter("password"));
			     
			     Studentuser = userDao.login(Studentuser);
			     
			     if(Studentuser.isValid()) {
			    	 HttpSession session = request.getSession();	    
				     session.setAttribute("currentSessionUser",Studentuser); 
			         response.sendRedirect("student.jsp"); 
			     }
			     else {
			    	 response.sendRedirect("index.jsp");
			     }
			}
			catch (Throwable theException) {
				System.out.println(theException);
			}
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
