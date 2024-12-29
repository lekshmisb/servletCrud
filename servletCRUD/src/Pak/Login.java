package Pak;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Pack.User;
import Pack.Userdao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
       User n=Userdao.checklogindetails(email, password);
       
        if (n.getId()!=0)//to find matching user
        {
        	
        	
           if(n.getUtype().equals("admin"))
           {
        	   System.out.println("sucess");
//            request.getRequestDispatcher("Adminhome").forward(request,response);
        	   response.sendRedirect("Adminhome");
     	   }
        else 
        {
            
          request.getRequestDispatcher("Userhome").forward(request, response);
        }
        }   
           else
           {
        	out.print("INVALID EMAIL AND PASSWORD"); 
        	
            request.getRequestDispatcher("Login.html").include(request, response);

           }
        
        }
}



