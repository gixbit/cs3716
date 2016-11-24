import java.util.ArrayList;

/**
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 */
public interface Structure {
	public void createBrackets(ArrayList<Team> teamList);
	
	public void advanceTournament();
	
	public ArrayList<Bracket> getBrackets();
	
	
}
