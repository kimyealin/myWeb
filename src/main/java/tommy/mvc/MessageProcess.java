package tommy.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Controller�κ��� �۾�ó�� ���ù޾Ƽ� �۾��� ó��
public class MessageProcess implements CommandProcess{
	//���� ����ٰ� �ʿ信���� VO,DAO�� �ʱ�ȭ�ϰ� �����ͺ��̽� �����ϰ�
	//�Ʒ��� ���� ������� ������
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable{
		request.setAttribute("message", "��û �Ķ���ͷ� ��ɾ ����");
		return "/mvc/process.jsp";
	}
}
