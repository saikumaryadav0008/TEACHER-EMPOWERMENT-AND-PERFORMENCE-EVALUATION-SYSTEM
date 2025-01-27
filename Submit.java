package com.task;

import java.io.IOException;  

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Submit extends HttpServlet {
	public void doPost(HttpServletRequest req ,HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("html/text");
		//int stuId =Integer.parseInt(req.getParameter("stuId"));
		String TeacherName = req.getParameter("TeacherName");
		String Password = req.getParameter("Password");
		
		Date date =new Date(new java.util.Date().getTime());
		//String stuMail = req.getParameter("stuEmail");
		//String pwd = req.getParameter("stuPwd");
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://@localhost:3306/Registrations",
					"root","2444");
			PreparedStatement pst=con.prepareStatement(
					"insert into LoginData values(?,?) ");
			pst.setString(1, TeacherName);
			pst.setString(2, Password);
			/**pst.setString(3, stuAdd);
			pst.setDate(4, date);
			pst.setString(5, stuMail);
			pst.setString(6, pwd);*/
			pst.executeUpdate();
			pst.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		pw.println("Registration is success");
		res.sendRedirect("registersuccess.html");
		}
	}