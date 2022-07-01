package tommy.mvc.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tommy.mvc.control.ActionForward;

public class IndexAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("IndexAction의 execute() 수행됨!!");
		return new ActionForward("index.jsp", false);
	}
	
	/*
	 * 원래 여기서 데이터베이스 연동작업이 필요하면 VO, DAO를 초기화하고 
	 * 연동을 수행하고 값을 받아와서 처리를 수행해야 함.
	 * 그리고 처리한 결과값을 request, setAttribute(key, value)메서드를 이용해
	 * 뷰에 전달한 값을 셋팅함
	 */

}
