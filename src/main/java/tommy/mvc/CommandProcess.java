package tommy.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//지난번 명령어 전달하는 방식의 Action인터페이스에 해당하는 슈퍼인터페이스
public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;
}
