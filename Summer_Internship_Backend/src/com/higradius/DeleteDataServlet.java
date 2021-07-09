package com.higradius;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDataServlet
 */
@WebServlet("/DeleteDataServlet")
public class DeleteDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDataServlet() {
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
String salesOrder = null;
		
		try {
			BufferedReader reader = request.getReader();
			salesOrder = reader.readLine();
			System.out.println(salesOrder);
			
			salesOrder = salesOrder.split(":")[1];
			salesOrder = salesOrder.substring(1,  salesOrder.length() - 2);
			
			String final_values[] = salesOrder.split(",");
			
			Connection conn = GetConnection.connectToDB();
			
			String sql_statement = "DELETE FROM mytable WHERE invoice_id = ?";
			
			for(int i=0; i< final_values.length; ++i)
			{
				PreparedStatement st = conn.prepareStatement(sql_statement);
				st.setString(1, final_values[i]);
				System.out.println(st);
				st.executeUpdate();
			}
			conn.close();
			
	}
	catch(Exception e)
		{
		
		}
	}
}

