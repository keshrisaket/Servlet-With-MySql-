package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import DatabaseConnectionProvider.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import jakarta.servlet.http.HttpSession;


public class FinalServ extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw =response.getWriter();
	     Connection c=DatabaseConnection.getConnection();
	     System.out.println(c);
	     String name="";
	     String address="";
	     float age=0;
	     float experience=0;
	     String skills="";
	     
	     
	     
	     String salary=request.getParameter("salary");
	     String location=request.getParameter("location");
	     
	     
	     HttpSession hs=request.getSession();
	     
	     if(!hs.isNew()) {
	    	  name=(String)hs.getAttribute("name");
	    	  address=(String)hs.getAttribute("address");
	    	  age=(float) hs.getAttribute("age");
	    	  experience=(float) hs.getAttribute("experience");
	    	  skills =(String) hs.getAttribute("skills");
	     }
	     
	      boolean  ins= insertData(c, name, address, age, experience, skills, Double.parseDouble(salary), location);
	      if(ins) {
	    	  pw.write("<html>\r\n"
		  				+ "<head>\r\n"
		  				+ "<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.css\">\r\n"
		  				+ "<meta charset=\"UTF-8\">\r\n"
		  				+ "<title>Insert title here</title>\r\n"
		  				+ "<style>\r\n"
		  				+ "  body { background-color: white; color: black; display: flex; justify-content: center; align-items: center; height: 100vh; }\r\n"
		  				+ "  .message-box { background-color: red; color: white; padding: 20px; border-radius: 10px; text-align: center; }\r\n"
		  				+ "  a { color: white; text-decoration: none; font-weight: bold; }\r\n"
		  				+ "  a:hover { color: darkred; }\r\n"
		  				+ "</style>\r\n"
		  				+ "</head>\r\n"
		  				+ "<body>\r\n"
		  				+ "  <div class=\"message-box\">\r\n"
		  				+ "    Successfully Inserted\r\n"
		  				+ "    <br>\r\n"
		  				+ "    <a href=\"Home.html\">Home</a>\r\n"
		  				+ "  </div>\r\n"
		  				+ "</body>\r\n"
		  				+ "</html>");

	      }else {

	    	  pw.write("<html>\r\n"
	  	 			+ "<head>\r\n"
	  				+ "<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.css\">\r\n"
	  				+ "<meta charset=\"UTF-8\">\r\n"
	  				+ "<title>Insert title here</title>\r\n"
	  				+ "<style>\r\n"
	  				+ "  body { background-color: white; color: black; display: flex; justify-content: center; align-items: center; height: 100vh; }\r\n"
	  				+ "  .message-box { background-color: red; color: white; padding: 20px; border-radius: 10px; text-align: center; }\r\n"
	  				+ "  a { color: white; text-decoration: none; font-weight: bold; }\r\n"
	  				+ "  a:hover { color: darkred; }\r\n"
	  				+ "</style>\r\n"
	  				+ "</head>\r\n"
	  				+ "<body>\r\n"
	  				+ "  <div class=\"message-box\">\r\n"
	  				+ "    Failed to Insert Data\r\n"
	  				+ "    <br>\r\n"
	  				+ "    <a href=\"Home.html\">Home</a>\r\n"
	  				+ "  </div>\r\n"
	  				+ "</body>\r\n"
	  				+ "</html>");

	      }
		
	}
	
	
	public boolean insertData(Connection con,String name,String address,float age,float experience,String skills,double salary,String preffered_location) {
		
		try {
			
		PreparedStatement ps =con.prepareStatement("insert into user_info (name,address,age,experience,skills,salary,preffered_location) values (?,?,?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,address);
		ps.setFloat(3, age);
		ps.setFloat(4, experience);
		ps.setString(5,skills);
		ps.setDouble(6,salary);
		ps.setString(7,preffered_location);
		int status=ps.executeUpdate();
		if(status>0) {
			return true;
		}else {
			return false;
		}
		
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
			
		
	}

}
