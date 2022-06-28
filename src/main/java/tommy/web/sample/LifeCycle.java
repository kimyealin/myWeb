package tommy.web.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String company;
	private String manager;
	private String tel;
	private String email;

	// 생성자
	public LifeCycle() {
		System.out.println("LifeServlet의 생성자 호출됨...");
	}

	@Override
	// LifeServlet의 초기화 작업 담당
	// Servlt객체 생성시 단 한번 수행됨
	public void init() throws ServletException {
		System.out.println("init() 호출됨!!!!");
		// ServletContext의 초기 파라미터 값 읽기
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");

		// servletConfig의 초기 파라미터 값 읽기
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
	}

	@Override
	// LifeServlet객체가 WAS에서 소멸될때 수행됨
	public void destroy() {
		System.out.println("destroy() 호출됨!!!!");
	}

	@Override
	// 클라이언트 연결요청 있을때마다 호출됨
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() 호출됨!!!!!!!!!");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<html>");
			out.println("<body>");
			out.println("<li>회사명 : " + company + "</li>");
			out.println("<li>담당자 : " + manager + "</li>");
			out.println("<li>전화번호 : " + tel + "</li>");
			out.println("<li>이메일 : " + email + "</li>");
			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();
		}
	}

}
