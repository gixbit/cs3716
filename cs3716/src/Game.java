
/**
 * Describes a Game used in a tournament.
 * Each game has two teams and scores for both.
 * Keeps track of the completion and venue as well.
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 */
public class Game {		//coming back later to add time and venue if we want them
	/**
	 * The venue this game is located
	 */
	private String venue; //If we need a venue object we can make that later
	/**
	 * The time of this game
	 */
	private String time;
	/**
	 * The first team
	 */
	private Team teamOne;
	/**
	 * The second team
	 */
	private Team teamTwo;
	/**
	 * The first team's score
	 */
	private int teamOneScore;
	/**
	 * The second team's score.
	 */
	private int teamTwoScore;
	/**
	 * If this is true, the game has concluded.
	 */
	private boolean complete;
	
	public Game(Team one, Team two){
		teamOne = one;
		teamTwo = two;
//		venue = location;
		complete = false;
	}
	public void setScoreOne(int i){
		teamOneScore = i;
		complete = false;						//To prevent completing the game and then going back and entering a new result that doesn't work.
	}
	public void setScoreTwo(int i){
		teamTwoScore = i;
		complete = false;	
	}
	public int getScoreOne(){
		return teamOneScore;
	}
	public int getScoreTwo(){
		return teamTwoScore;
	}
	public void setLocation(String location){
		venue = location;
	}
	public void setTime(String t){
		time = t;
	}
	public String getVenue(){
		return venue;
	}
	public String getTime(){
		return time;
	}
	public void completeGame(){
		if (teamOneScore + teamTwoScore > 27){
			if ((teamOneScore > teamTwoScore) || (teamTwoScore > teamOneScore)){		//Normally you have to be ahead by 2 points but in the following case a valid score could be the final score of a game: the receiving team either scored the last point or earned a side-out in the last point and the receiving team is ahead by 1 point. In this case the receiving team wins.
				complete = true;
			}
		}
	}
	public boolean isComplete(){
		return complete;
	}
	public Team getWinner(){		//Don't call this unless you've already checked if the game is complete
		if (teamOneScore > teamTwoScore){return teamOne;} else {return teamTwo;}
	}
	public Team getLoser(){		//Don't call this unless you've already checked if the game is complete
		if (teamOneScore < teamTwoScore){return teamOne;} else {return teamTwo;}
	}
	public int getWinnerScore(){
		if (teamOneScore > teamTwoScore){return teamOneScore;} else {return teamTwoScore;}
	}
	public int getLoserScore(){
		if (teamOneScore < teamTwoScore){return teamOneScore;} else {return teamTwoScore;}
	}
}
