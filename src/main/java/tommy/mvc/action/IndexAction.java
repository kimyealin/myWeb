package tommy.mvc.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tommy.mvc.control.ActionForward;

public class IndexAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("IndexAction�� execute() �����!!");
		return new ActionForward("index.jsp", false);
	}
	
	/*
	 * ���� ���⼭ �����ͺ��̽� �����۾��� �ʿ��ϸ� VO, DAO�� �ʱ�ȭ�ϰ� 
	 * ������ �����ϰ� ���� �޾ƿͼ� ó���� �����ؾ� ��.
	 * �׸��� ó���� ������� request, setAttribute(key, value)�޼��带 �̿���
	 * �信 ������ ���� ������
	 */

}
