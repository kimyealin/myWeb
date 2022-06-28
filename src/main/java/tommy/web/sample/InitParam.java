package tommy.web.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String company;
	private String manager;
	private String tel;
	private String email;
	 

    @Override
	public void init() throws ServletException {
		System.out.println("�ʱ�ȭ �޼ҵ� �����");
		
		//ServletContext�� �ʱ� �Ķ���� �� �б�
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");
		
		//servletConfig�� �ʱ� �Ķ���� �� �б�
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	try {
			response.setContentType("text/html;charset=euc-kr");
			out.println("<html>");
			out.println("<body>");
			out.println("<li>ȸ��� : " + company + "</li>");
			out.println("<li>����� : " + manager + "</li>");
			out.println("<li>��ȭ��ȣ : " + tel + "</li>");
			out.println("<li>�̸��� : " + email + "</li>");
			out.println("</body>");
			out.println("</html>");

		}finally{
			out.close();
		} 
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
