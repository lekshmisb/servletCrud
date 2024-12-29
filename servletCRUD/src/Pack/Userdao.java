package Pack;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Pack.User;

public class Userdao 
{
	public static Connection getConnection()
	{
		Connection con=null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");	
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int saveUser(User u)//method used to save and user is passed
	{
		int status=0;
		u.setUtype("user");//setting utype as user,entered value in database is shown as user initially
	try 
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into table1(fname,lname,state) values(?,?,?)");
		ps.setString(1, u.getFname());
		ps.setString(2, u.getLname());
		ps.setString(3, u.getState());
		status=ps.executeUpdate();
		
		PreparedStatement ps1=con.prepareStatement("select max(id) from table1");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			u.setId(rs.getInt(1));
		}
		
		PreparedStatement ps2=con.prepareStatement("insert into table2(email,password,utype,userid) values(?,?,?,?)");
		ps2.setString(1, u.getEmail());
		ps2.setString(2, u.getPassword());
		ps2.setString(3, u.getUtype());
		ps2.setInt(4, u.getId());
		status+=ps2.executeUpdate();
	} 
	catch (Exception e) 
	{
		System.out.println(e);
	}
	return status;
	}
	
	public static User checklogindetails(String email, String password)
	{
		User uc=new User();
		
		
		try 
		{
			Connection con=getConnection();
			
			
           PreparedStatement ps3 = con.prepareStatement("SELECT table1.id, table1.fname, table1.lname, table1.state, table2.email, table2.password, table2.utype " +
					"FROM table1 LEFT JOIN table2 ON table1.id = table2.userid "+
					"WHERE table2.email = ? AND table2.password = ?");
	       
	        ps3.setString(1, email);
	        ps3.setString(2, password);

	        ResultSet rs = ps3.executeQuery();
	        
	        while(rs.next())
	        {
	        	
	        	uc.setId(rs.getInt(1));
	        	uc.setFname(rs.getString(2));
	        	uc.setLname(rs.getString(3));
	        	uc.setState(rs.getString(4));
	        	uc.setEmail(rs.getString(5));
	        	uc.setPassword(rs.getString(6));
	        	uc.setUtype(rs.getString(7));
	        	
	        }
	        
	        
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}

	    return uc; 
	  
	}
	
	public static List<User> getAllUsers() 
	{
	    List<User> ug=new ArrayList<>();

	    try {
	        
	        Connection con = getConnection();
	        PreparedStatement ps4 = con.prepareStatement(
	        		"select table1.id, table1.fname, table1.lname, table1.state, table2.email, table2.password, table2.utype " +
	        "from table1 left join table2 on table1.id = table2.userid");

	        ResultSet rs = ps4.executeQuery();
	            
	            while (rs.next()) 
	            {
	            User uc = new User();
	            uc.setId(rs.getInt(1));
	            uc.setFname(rs.getString(2));
	            uc.setLname(rs.getString(3));
	            uc.setState(rs.getString(4));
	            uc.setEmail(rs.getString(5));
	            uc.setPassword(rs.getString(6));
	            uc.setUtype(rs.getString(7));

	            ug.add(uc);
	        }

	    } 
	    catch (Exception e) 
	    {
	        System.out.println(e);
	    }

	    return ug;
	}
	
	public static User getAllUserById(int id)
	{
		User u=new User();
		try 
		{
			Connection con=getConnection();
		    PreparedStatement ps3 = con.prepareStatement("select table1.id,table1.fname,table1.lname,table1.state,table2.email,table2.password,table2.utype from table1 left join table2 on table1.id=table2.userid where userid=?");
		       
		        ps3.setInt(1, id);
		       ResultSet rs = ps3.executeQuery();
		        
		        while(rs.next())
		        {
		        	u.setId(rs.getInt(1));
		        	u.setFname(rs.getString(2));
		        	u.setLname(rs.getString(3));
		        	u.setState(rs.getString(4));
		        	u.setEmail(rs.getString(5));
		        	u.setPassword(rs.getString(6));
		        	u.setUtype(rs.getString(7));
		        }
		} 
		catch (Exception e) 
		{
		System.out.println(e);	
		}
		return u;
	}
	
	public static int updateUser(User u)
	{
		int status=0;
		try 
		{
			Connection con=getConnection();
		    PreparedStatement ps = con.prepareStatement("update table2 set email=?,password=? where userid=?");
		      ps.setString(1, u.getEmail());
		      ps.setString(2, u.getPassword());
		      ps.setInt(3, u.getId());
		      status= ps.executeUpdate();
		      
		      PreparedStatement ps1 = con.prepareStatement("update table1 set fname=?,lname=?,state=? where id=?");
		      ps1.setString(1, u.getFname());
		      ps1.setString(2, u.getLname());
		      ps1.setString(3, u.getState());
		      ps1.setInt(4, u.getId());
		      
		      status+= ps1.executeUpdate();
		        } 
		catch (Exception e) 
		{
		System.out.println(e);	
		}
		return status;
	}
	
	public static int deleteUser(int id)
	{
		int status=0;
		try 
		{
			Connection con=getConnection();
		    PreparedStatement ps = con.prepareStatement("delete from table2 where userid=?");
		      ps.setInt(1, id);
		      status= ps.executeUpdate();
		      
		      PreparedStatement ps1 = con.prepareStatement("delete from table1 where id=?");
		      ps1.setInt(1, id);
		      status+= ps1.executeUpdate();
		        } 
		catch (Exception e) 
		{
		System.out.println(e);	
		}
		return status;
	}
	
	
}
	
	
    
	
	
	
	

       
    
	
	
	
	

	

