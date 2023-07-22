package com.sbank.services;
import java.sql.*;
import com.sbank.connection.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addUserServlet
 */
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
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
			
			PreparedStatement ps = con.prepareStatement("insert into accounts values(?,?,?,?,?,?,?)");
			ps.setString(1,(request.getParameter("acno")));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("contact"));
			ps.setString(4, request.getParameter("address"));
			ps.setString(5, request.getParameter("email"));
			ps.setString(6, request.getParameter("password"));
			ps.setInt(7, Integer.parseInt(request.getParameter("balance")));
			int i = ps.executeUpdate();
			if(i >0)
			{
				response.sendRedirect("NewFile.html");
			}
			else
			{
				response.sendRedirect("failed.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
