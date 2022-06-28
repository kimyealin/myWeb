package tommy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		try{
			out.println("<html><head><title>My First Servlet</title></head><body>");
			out.println("<h1 color='red'><br><center><font size='5'>지금은 ");
			out.println(new java.util.Date());
			out.println(" 입니다.</font></center></body></html>");
		}finally{
			out.close();
		}
	}
}
