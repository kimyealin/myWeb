package tommy.mvc.control;

import tommy.mvc.action.Action;
import tommy.mvc.action.IndexAction;

public class ActionFactory {
	//싱글톤
	private static ActionFactory factory;
	private ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	//명령어를 받아서 그 명령을 수행할 수 있는 해당 Action객체를 생성해서 리턴해줌
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
