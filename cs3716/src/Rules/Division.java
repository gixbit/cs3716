package Rules;

import Core.Team;
import Core.Tournament;

public class Division implements Rules {
	@Override
	public boolean AddTeam(Tournament t, Team n) {
		return true;
	}
	@Override
	public boolean RemoveTeam(Tournament t, Team n) {
		return true;
	}
	@Override
	public boolean HasWinner(Tournament t) {
		return false;
	}
}