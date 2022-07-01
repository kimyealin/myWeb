package tommy.mvc.control;

import tommy.mvc.action.Action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd"); //2. 요청분석
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance(); 
			//3. 명령을 처리할 수 있는 해당 Action객체 생성
			Action action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			//4. 명령에 대한 처리 수행하고 가야할 페이지를 얻어옴
			
			if(af.isRedirect()) { //5. 해당페이지로 이동시킴
				response.sendRedirect(af.getUrl());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
		}else { //명령어 안주어졌을때
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닙니다!!</h4>");
			out.println("<h4>http://localhost:8080/myWeb/mvc/test.do?cmd=요청키워드<h4>");
			out.println("</body>");
			out.println("</html>");
		}

	}
	

}
