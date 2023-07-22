package com.sbank.services;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sbank.connection.*;
/**
 * Servlet implementation class userLoginServlet
 */
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			
	
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps = con.prepareStatement("select * from accounts where acno=? and pass=?");
			
			ps.setString(1, request.getParameter("acno"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				response.sendRedirect("operation1.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
