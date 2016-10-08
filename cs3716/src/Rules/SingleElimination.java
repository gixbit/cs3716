package Rules;

import Core.Team;

public class SingleElimination implements Rules {
	@Override
	public boolean AddTeam(Team t) {
		return true;
	}
	@Override
	public boolean RemoveTeam(Team t) {
		return true;
	}
	@Override
	public boolean HasWinner() {
		return false;
	}
}