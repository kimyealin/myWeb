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
		
		//db에서 사용자 정보 조회 이부분 수정해서 만들어볼 것
//		String dbID = "admin";
//		String dbPWD = "1234";
			
//		if(dbID.equals(id) && dbPWD.equals(pwd)) {
//			HttpSession session = request.getSession(); //HttpSession객체얻기
//			session.setAttribute("user", id); //클라이언트 정보 HttpSession객체에 저장
//
//		}
//		response.sendRedirect("Login");
//	}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("드라이버 로딩 실패");
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
					System.out.println("로그인 성공");
				}else {
					System.out.println("비밀번호 틀림");
				}
			}else {
				System.out.println("아이디 없음");
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("쿼리문이 틀렸음");
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
