package Rules;

import Core.Team;

public interface Rules {
	boolean AddTeam(Team t);
	boolean RemoveTeam(Team t);
	boolean HasWinner();	
}
