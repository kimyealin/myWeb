package tommy.mvc.control;

import tommy.mvc.action.Action;
import tommy.mvc.action.IndexAction;

public class ActionFactory {
	//�̱���
	private static ActionFactory factory;
	private ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	//��ɾ �޾Ƽ� �� ����� ������ �� �ִ� �ش� Action��ü�� �����ؼ� ��������
	public Action getAction(String cmd) {
		Action action = null;
		if(cmd.equals("index")) {
			action = new IndexAction();
		}/* else if(cmd.equals("list")){
		action = new ListAction();
		*/
		return action;
	}
}
