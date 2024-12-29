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

/**
 * Servlet implementation class EditForm
 */
@WebServlet("/EditForm")
public class EditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int id=Integer.parseInt(request.getParameter("id"));
        User u=Userdao.getAllUserById(id);
        
        out.print(
        		"    <form action='Edit' method='post'>" +
                "       <input type='hidden' name='id' value="+u.getId()+">"+
        		"       <input type='text' name='fname' value="+u.getFname()+">"+
                "       <input type='text' name='lname' value="+u.getId()+">"+
        		
                "        <select name='state'  >"  +
                "         <option>"+u.getState()+"</option>" +
                "         <option>Kerala</option>" +
                "      <option>Karnataka</option>" +
                "    <option>Tamil Nadu</option> " +
                "   <option>Andra</option>\r\n   " +
                "   <option>Other</option>\r\n   " +
                "       </select>"+
                
                
   "<input type='email' name='email'  value="+u.getEmail()+">"+
   "<input type='password' name='passsword'  value="+u.getPassword()+">"+
   "<button type='submit'>Update</button>"+
   "</form>");

                
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
