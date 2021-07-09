package com.higradius;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddDataServlet
 */
@WebServlet("/AddDataServlet")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataServlet() {
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
		
		try {
			String customerName = request.getParameter("custName");
			String customerNumber = request.getParameter("custNum");
			String invoiceNumber = request.getParameter("invNo");
			String invoiceAmount = request.getParameter("invAmt");
			String dueDate = request.getParameter("due_Date");
			String notes = request.getParameter("note");
			
			
			Connection conn = GetConnection.connectToDB();
			System.out.println("DB Connected!");
			
			String sqladd = "insert into mytable (name_customer,cust_number,invoice_id,total_open_amount,due_in_date,notes) values (?,?,?,?,?,?)";
			
			PreparedStatement st= conn.prepareStatement(sqladd);
			st.setString(1, customerName);
			st.setString(2, customerNumber);
			st.setString(3, invoiceNumber);
			st.setString(4, invoiceAmount);
			st.setString(5,  dueDate);
			st.setString(6, notes);
			
			st.executeUpdate();
			
			conn.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
