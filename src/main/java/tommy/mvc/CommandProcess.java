package tommy.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������ ��ɾ� �����ϴ� ����� Action�������̽��� �ش��ϴ� �����������̽�
public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable;
}
