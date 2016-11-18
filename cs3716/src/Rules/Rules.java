package Rules;

import Core.Team;
import Core.Tournament;

public interface Rules {
	boolean AddTeam(Tournament t, Team n);
	boolean RemoveTeam(Tournament t, Team n);
	boolean HasWinner(Tournament t);	
}
