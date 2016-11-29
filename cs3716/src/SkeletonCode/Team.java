package SkeletonCode;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 * @author Karl Chiasson
 */
public class Team {
	/**
	 * The name of a team
	 */
	private String teamName;
	/**
	 * The list of the players on this team
	 */
	private ArrayList<String> playerList = new ArrayList<String>();
	/**
	 * The list of coaches for this team
	 */
	private ArrayList<String> coaches = new ArrayList<String>();
	/**
	 * The number of points this team has acrued
	 */
	private int points;
	/**
	 * The number of wins this team has acrued
	 */
	private int wins;
	/**
	 * The constructor for a team
	 * @param name - String
	 * @param c - String params
	 */
	public Team(String name, String ... c){
		teamName = name;
	//	playerList = pList;
		coaches = (ArrayList<String>)Arrays.asList(c);
		points = 0;
		wins = 0;
	}
	/**
	 * Returns the list of coaches this team contains.
	 * @return coaches -  ArrayList&ltString&gt
	 */
	public ArrayList<String> getCoaches(){
		return coaches;
	}
	/**
	 * Returns the list of players this team contains
	 * @return roster - ArrayList&ltString&gt
	 */
	public ArrayList<String> getRoster(){
		return playerList;
	}
	/**
	 * Returns the name of this team
	 * @return name - String
	 */
	public String getTeamName(){
		return teamName;
	}
	/**
	 * This is called when a team wins a game.
	 * Increments the wins of this team.
	 */
	public void win(){							//Call when a team wins a game
		wins++;
	}
	/**
	 * Adds to the total points this team has
	 * @param addition - Integer
	 */
	public void addPoints(int addition){		//Add points when a game is completed
		points += addition;
	}
	/**
	 * Returns the number of wins this team has
	 * @return wins - Integer
	 */
	public int getWins(){						//Gets number of wins
		return wins;
	}
	/**
	 * Returns the number of points this team has
	 * @return points - Integer
	 */
	public int getPoints(){						//Gets point total accross all games
		return points;
	}
}
