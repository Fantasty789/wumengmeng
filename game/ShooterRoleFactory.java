package game;

public class ShooterRoleFactory implements RoleFactory {

	@Override
	public Role CreateRole() {
		// TODO Auto-generated method stub
		return new ShooterRole();
	}

}
