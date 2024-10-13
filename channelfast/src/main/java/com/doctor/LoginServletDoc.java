package com.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServletDoc")
public class LoginServletDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = DoctorDBUtil.validate(username, password);
		
		if(isTrue == true) {
			
			List<Doctor> docDetails = DoctorDBUtil.getDoctor(username);
			request.setAttribute("docDetails", docDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("doctoraccount.jsp");
			dis.forward(request, response);
			
		}else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Your username and pasword is incorrect');");
				out.println("location='logindoc.jsp'");
				out.println("</script>");
			}
			
		
		
	}

}