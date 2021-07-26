package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDataServlet
 */
@WebServlet("/EditDataServlet")
public class EditDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDataServlet() {
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
		//doGet(request, response);
		try {
			String fieldValue = request.getParameter("uniqueId");
			int field = Integer.parseInt(fieldValue);
			String newInAmt = request.getParameter("inamt");
			float newInvoiceAmt = Float.parseFloat(newInAmt);
			String nNotes = request.getParameter("nns");
		
			Connection conn = GetConnection.connectToDB();
			System.out.println("DB Connected!");
		
			String sqlEdit = "update mytable set total_open_amount = ? , notes = ? where FIELD1 = ?";
		
			PreparedStatement st = conn.prepareStatement(sqlEdit);
			st.setFloat(1, newInvoiceAmt);
			st.setString(2, nNotes);
			st.setInt(3, field);
		
			st.executeUpdate();
			conn.close();
		}catch (IOException e) {
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
