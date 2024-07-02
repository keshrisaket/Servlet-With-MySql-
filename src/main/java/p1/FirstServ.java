package p1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;


public class FirstServ extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name =request.getParameter("name");
		String address=request.getParameter("address");
		String age=request.getParameter("age");
		
		System.out.println(name+address+age);
		
		// Session management via HttpSession 
		HttpSession hs =request.getSession(true); 
		
		if(hs.isNew()) {
	    hs.setAttribute("name",name);
	    hs.setAttribute("address",address);
	    hs.setAttribute("age",Float.parseFloat(age));
		}
		
		
		
		
		
		
		
		PrintWriter pw=response.getWriter();
		pw.write("\r\n"
				+ "	<html>\r\n"
				+ "	<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.css\">\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<title>Session Tracking</title>\r\n"
				+ "	<style>\r\n"
				+ "		body { background-color: white; color: black; }\r\n"
				+ "		.container { background-color: red; padding: 20px; border-radius: 10px; max-width: 400px; margin-top: 50px; }\r\n"
				+ "		form { background-color: white; padding: 20px; border-radius: 10px; }\r\n"
				+ "		label { display: block; margin-bottom: 10px; font-weight: bold; }\r\n"
				+ "		input[type='number'], input[type='text'] { width: 100%; padding: 10px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 5px; }\r\n"
				+ "		input[type='submit'] { background-color: red; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; }\r\n"
				+ "		input[type='submit']:hover { background-color: darkred; }\r\n"
				+ "	</style>\r\n"
				+ "	</head>\r\n"
				+ "	<body>\r\n"
				+ "		<div class=\"container\">\r\n"
				+ "			<h2>Session Tracking</h2>\r\n"
				+ "			<form action=\"SecondServ\" method=\"post\">\r\n"
				+ "				<label>Enter your experience</label>\r\n"
				+ "				<input type=\"number\" name=\"experience\" required>\r\n"
				+ "				<label>Enter your skills</label>\r\n"
				+ "				<input type=\"text\" name=\"skills\" required>\r\n"
				+ "				<input type=\"submit\" value=\"Continue\">\r\n"
				+ "			</form>\r\n"
				+ "	   </div>\r\n"
				+ "	</body>\r\n"
				+ "	</html>\r\n"
				+ "	");

		
		
	}

}