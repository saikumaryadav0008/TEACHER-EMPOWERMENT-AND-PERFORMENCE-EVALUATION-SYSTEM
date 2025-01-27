package com.task;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCredentials extends HttpServlet {
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String UserName = req.getParameter("UserName");
			String  Password= req.getParameter("Password");
			if(UserName.equals(null)  && Password  == " ") {
				pw.println("enter your Login details");
			}
		    else if (("Saikumaryadav".equals(UserName) && "2444".equals(Password))||("UdayKiran".equals(UserName) && "9381".equals(Password))||("VeeraBiksham".equals(UserName) && "9553".equals(Password))||("Srikanth".equals(UserName) && "8519".equals(Password)))
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=
					DriverManager.getConnection("jdbc:mysql://@localhost:3306/Registrations","root","2444");
					PreparedStatement pst=con.prepareStatement("select *from LoginData");
					pw.print("<table width = 100% border = 1 border-color=black >");
					ResultSet rs=pst.executeQuery();
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					int total = rsmd.getColumnCount();
					pw.print("<tr>");
					for(int i = 1; i<= total-1; i++)
					{
						pw.print("<th>" + rsmd.getColumnName(i) + "</th>");
					}
					pw.print("</tr>");
					while(rs.next())
					{
						pw.println("<tr><td>"+ " " + rs.getInt(1)+"</td><td>"+ " "+ rs.getString(2));
					}
					pw.print("</table>");

						}

				catch(Exception e) {
					e.printStackTrace();
					
				}
			}
		   
			else
			{
				pw.println("Check your Login Credentials");
			}
		    
		
	}
}