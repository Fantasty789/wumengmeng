package command;

import java.util.ArrayList;

public class WaiterInvoker {
	private ArrayList<Command>commands=null;
	
	public WaiterInvoker() {
		// TODO Auto-generated constructor stub
		commands=new ArrayList<Command>();
	}

	public void setCommands(Command cmd) {
		commands.add(cmd);
	}
	public void OrderUp() {
		System.out.println("ÓÐ¶©µ¥");
		for(Command cmd:commands) {
			if(cmd!=null) {
				cmd.execute();
			}
		}
	}

}
