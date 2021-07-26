package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//JDBC Driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/invoicedb";
		
		//Database credentials
		static final String USER = "root";
		static final String PASSWORD = "sv8530";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn= null;
		Statement stmt= null;//sql statement with with we'll fetch the data 
		int rowToGet = 11;
		List<Response> demoList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);
			stmt = conn.createStatement();
			String sql;//(offset,count) off= pageno- 1 
			
			String pageInURL = request.getParameter("page");
			int page = Integer.parseInt(pageInURL) * rowToGet;
			
//			int pageno=(Integer.valueOf(request.getParameter("page")))*rowtoget;
			
			sql="select FIELD1,name_customer,cust_number,invoice_id,total_open_amount,due_in_date,predicted_clear_date,notes from myTable limit "+((page-1)*11+1)+","+11;
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Response demo = new Response();
				demo.setField1(rs.getString("FIELD1"));
				demo.setNameCustomer(rs.getString("name_customer"));
				demo.setCustNumber(rs.getString("cust_number"));
				demo.setPredictedClearDate(rs.getString("predicted_clear_date"));
				demo.setInvoiceID(rs.getString("invoice_id"));
				demo.setDueInDate(rs.getString("due_in_date"));
				demo.setTotalOpenAmount(rs.getFloat("total_open_amount"));
				demo.setNotes(rs.getString("notes"));
				demoList.add(demo);
			}
			//Converting demoList to JSON 
			Gson gson = new GsonBuilder().serializeNulls().create();
			String jsonString = gson.toJson(demoList);
			
			//String jsonString = getJSONStringFromObject(demoList);
			response.setContentType("application/json");
			
			try {
				response.getWriter().write(jsonString);//getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
			}catch(SQLException se2) {
			}
			try {
				 if(conn!=null)
					 conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
