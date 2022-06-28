package tommy.web.login;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//db���� ����� ���� ��ȸ �̺κ� �����ؼ� ���� ��
//		String dbID = "admin";
//		String dbPWD = "1234";
			
//		if(dbID.equals(id) && dbPWD.equals(pwd)) {
//			HttpSession session = request.getSession(); //HttpSession��ü���
//			session.setAttribute("user", id); //Ŭ���̾�Ʈ ���� HttpSession��ü�� ����
//
//		}
//		response.sendRedirect("Login");
//	}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("����̹� �ε� ����");
		}
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			pstmt = conn.prepareStatement("select pass from login where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(pwd.equals(dbPass)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", id);
					System.out.println("�α��� ����");
				}else {
					System.out.println("��й�ȣ Ʋ��");
				}
			}else {
				System.out.println("���̵� ����");
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("�������� Ʋ����");
		}finally {
			try {if(rs != null) rs.close();}catch(SQLException e){}
			try {if(pstmt != null) pstmt.close();}catch(SQLException e) {}
			try {if(conn != null) conn.close();}catch(SQLException e) {}
		}
		response.sendRedirect("Login");
	}
		

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
