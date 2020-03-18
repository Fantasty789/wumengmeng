package game;

public class MasterRoleFactory implements RoleFactory {

	@Override
	public Role CreateRole() {
		// TODO Auto-generated method stub
		return new MasterRole();
	}
}
