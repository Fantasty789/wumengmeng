package game;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleFactory rolefactory = new MasterRoleFactory();
		rolefactory.CreateRole().MakeRole();

		rolefactory = new ShooterRoleFactory();
		rolefactory.CreateRole().MakeRole();

	}

}
