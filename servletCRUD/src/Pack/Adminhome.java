package Pack;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Adminhome
 */
@WebServlet("/Adminhome")
public class Adminhome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminhome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	 TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<User>ug= new ArrayList<>();
        out.print("<h1>WELCOME ADMIN</h1>");       
        
        
        ug=Userdao.getAllUsers();
        
       
        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<th>User ID</th>");
        out.print("<th>First Name</th>");
        out.print("<th>Last Name</th>");
        out.print("<th>State</th>");
        out.print("<th>Email</th>");
        out.print("<th>Password</th>");
        out.print("<th>Utype</th>");
        out.print("<th><a>Update</a></th>");
        out.print("<th><a>Delete</a></th>");
        out.print("</tr>");

            for (User u:ug) 
            {
                    out.print("<tr>");
           		    out.print("<td>" + u.getId() + "</td>");
           		    out.print("<td>" + u.getFname() + "</td>");
           		    out.print("<td>" + u.getLname() + "</td>");
           		    out.print("<td>" + u.getState() + "</td>");
           		    out.print("<td>" + u.getEmail() + "</td>");
           		    out.print("<td>" + u.getPassword() + "</td>");
           		    out.print("<td>" + u.getUtype() + "</td>");
           		    out.print("<td><a href='EditForm?id="+u.getId()+"'>Edit</a></td>");
           		    out.print("<td><a href='Delete?id="+u.getId()+"'>Delete</a></td>");
           		  
           		    
           		    out.print("</tr>");
           		} 
            


            out.print("</table>");
            }
            
            
   
        
      
	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    
		
		}

}
	
