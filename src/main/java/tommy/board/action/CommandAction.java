package tommy.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ���� �������̽�
public interface CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;

}
