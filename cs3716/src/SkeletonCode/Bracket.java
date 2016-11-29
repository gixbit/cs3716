package SkeletonCode;
import java.util.ArrayList;

/**
 * 
 * This class describes a Tournament Bracket. It takes a list of teams, and from that it
 * makes new games. It checks to see if the games are all completed. It returns the winners
 * and losers.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class Bracket {
	/**
	 * List of teams
	 */
	private ArrayList<Team> teamList = new ArrayList<Team>();
	/**
	 * List of games
	 */
	private ArrayList<Game> gameList = new ArrayList<Game>();
	/**
	 * If there is an odd amount of teams, this is true.
	 */
	private boolean odd;
	/**
	 * The constructor of a Bracket object
	 * @param list - ArrayList&ltTeam&gt
	 */
	public Bracket(ArrayList<Team> list){
		teamList = list;
		if ((teamList.size() % 2) > 0){ odd = true; } else{ odd = false; }
	}
	/**
	 * Make the games this bracket holds
	 * Does not currently do seeding.
	 */
	public void makeGames(){
		for (int i = 0; i < (teamList.size() / 2); i++){
			makeGame(teamList.get(i * 2), teamList.get(i * 2 + 1));
		}
	}
	/**
	 * Make a game from two teams and add it to the list of games.
	 * 
	 * @param Team - one
	 * @param Team - two
	 */
	public void makeGame(Team one, Team two){
		Game game = new Game(one, two);
		gameList.add(game);
	}
	/**
	 * Return the games this bracket holds.
	 * @return gameList - ArrayList&ltGame&gt
	 */
	public ArrayList<Game> getGames(){
		return gameList;
	}
	/**
	 * Check the completeness of all games. Returns true if all games are complete.
	 * @return complete - boolean
	 */
	public boolean checkComplete() {
		boolean complete = true;
		for (int i = 0; i < gameList.size(); i++){
			if (!gameList.get(i).isComplete()){complete = false;}
		}
		return complete;
	}
	/**
	 * Only call this if the games are complete. 
	 * Returns a list of the winners in this bracket.
	 * Adds the bye to the winners as well.
	 * 
	 * @return winners - ArrayList&ltTeam&gt
	 */
	public ArrayList<Team> getWinners() {
		ArrayList<Team> winners = new ArrayList<Team>();
		for (int i = 0; i < gameList.size(); i++){
			winners.add(gameList.get(i).getWinner());
		}
		if (odd) {winners.add(teamList.get(teamList.size() - 1));}		//Adds the bye to the winners
		return winners;
	}
	/**
	 * Only call this if the games are complete.
	 * Returns a list of all the losers in this bracket.
	 * Useful for double elimination, if double elim is ever done.
	 * @return losers - ArrayList&ltTeam&gt
	 */
	public ArrayList<Team> getLosers(){		//Only call if all games are complete, returns all losers, useful for double elim
		ArrayList<Team> losers = new ArrayList<Team>();
		for (int i = 0; i < gameList.size(); i++){
			losers.add(gameList.get(i).getLoser());
		}
		return losers;
	}
}