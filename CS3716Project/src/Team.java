import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<String> playerList = new ArrayList<String>();
	private ArrayList<String> coaches = new ArrayList<String>();
	private int points;
	private int wins;
	
	public Team(String name, ArrayList<String> pList, ArrayList<String> cList){
		teamName = name;
		playerList = pList;
		coaches = cList;
		points = 0;
		wins = 0;
	}
	public ArrayList<String> getCoaches(){
		return coaches;
	}
	public ArrayList<String> getRoster(){
		return playerList;
	}
	public String getTeamName(){
		return teamName;
	}
	public void win(){							//Call when a team wins a game
		wins++;
	}
	public void addPoints(int addition){		//Add points when a game is completed
		points = points + addition;
	}
	public int getWins(){						//Gets number of wins
		return wins;
	}
	public int getPoints(){						//Gets point total accross all games
		return points;
	}
}
