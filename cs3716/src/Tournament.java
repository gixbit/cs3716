import java.util.ArrayList;

/**
 * This is the major class this project uses.
 * Holds teams, start dates, end dates, and the type of this tournament as an integer
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 */
public class Tournament {
	/**
	 * The date this tournament will start
	 */
	private String startDate;			//Start and end dates are when one is allowed to register for the tournament
	/**
	 * The date this tournament will end
	 */
	private String endDate;
	/**
	 * The tournament type as an integer
	 */
	private int tType;
	/**
	 * The tournament name as a string
	 */
	private String tournamentName;
	/**
	 * The list of teams of this tournament
	 */
	private ArrayList<Team> teamList = new ArrayList<Team>();
	/**
	 * The Tournament constructor. Takes Name, start and end dates, and the structure as an integer
	 * @param name - String
	 * @param sDate - String
	 * @param eDate - String
	 * @param structure - Integer
	 */
	public Tournament(String name, String sDate, String eDate, int structure){
		startDate = sDate;
		endDate = eDate;
		tournamentName = name;
		tType = structure;
	}
	/**
	 * Returns the name of this tournament
	 * @return tournamentName - String
	 */
	public String getName(){
		return tournamentName;
	}
	/**
	 * Sets the name of this tournament
	 * @param name - String
	 */
	public void setName(String name){
		tournamentName = name;
	}
	/**
	 * Returns the start date of this Tournament
	 * return startDate - String
	 */
	public String getStartDate(){
		return startDate;
	}
	/**
	 * Set the start date of this tournament
	 * @param date - String
	 */
	public void setStartDate(String date){
		startDate = date;
	}
	/**
	 * Returns the end date of this Tournament
	 * @return endDate - String
	 */
	public String getEndDate(){
		return endDate;
	}
	/**
	 * Sets the end date of this Tournament
	 * @param date - String
	 */
	public void setEndDate(String date){
		endDate = date;
	}
	/**
	 * Add a team to the tournament
	 * @param team - Team
	 */
	public void addTeam(Team team){
		teamList.add(team);
	}
	/**
	 * Returns the list of teams of this Tournament
	 * @return teamList - ArrayList&ltTeam&gt
	 */
	public ArrayList<Team> getTeamList(){
		return teamList;
	}
	/**
	 * Returns the type of this tournament
	 * @return tType - Integer
	 */
	public int getType(){
		return tType;
	}
	/**
	 * Set the Tournament type
	 * @param t - Integer
	 */
	public void setType(int t){
		tType = t;
	}
	
}
