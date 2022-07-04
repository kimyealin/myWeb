package tommy.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller로부터 작업처리 지시받아서 작업을 처리
public class MessageProcess implements CommandProcess{
	//원래 여기다가 필요에따라 VO,DAO를 초기화하고 데이터베이스 연동하고
	//아래와 같이 결과값을 셋팅함
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		request.setAttribute("message", "요청 파라미터로 명령어를 전달");
		return "/mvc/process.jsp";
	}
}
