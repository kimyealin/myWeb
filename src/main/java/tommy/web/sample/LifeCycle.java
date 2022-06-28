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

	// ������
	public LifeCycle() {
		System.out.println("LifeServlet�� ������ ȣ���...");
	}

	@Override
	// LifeServlet�� �ʱ�ȭ �۾� ���
	// Servlt��ü ������ �� �ѹ� �����
	public void init() throws ServletException {
		System.out.println("init() ȣ���!!!!");
		// ServletContext�� �ʱ� �Ķ���� �� �б�
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");

		// servletConfig�� �ʱ� �Ķ���� �� �б�
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
	}

	@Override
	// LifeServlet��ü�� WAS���� �Ҹ�ɶ� �����
	public void destroy() {
		System.out.println("destroy() ȣ���!!!!");
	}

	@Override
	// Ŭ���̾�Ʈ �����û ���������� ȣ���
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() ȣ���!!!!!!!!!");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<html>");
			out.println("<body>");
			out.println("<li>ȸ��� : " + company + "</li>");
			out.println("<li>����� : " + manager + "</li>");
			out.println("<li>��ȭ��ȣ : " + tel + "</li>");
			out.println("<li>�̸��� : " + email + "</li>");
			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();
		}
	}

}
