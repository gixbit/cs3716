package skeletonCode;

import java.util.ArrayList;

public class Bracket {
	private ArrayList<Team> teamList = new ArrayList<Team>();
	private ArrayList<Game> gameList = new ArrayList<Game>();
	private boolean odd;
	
	public Bracket(ArrayList<Team> list){
		teamList = list;
		if ((teamList.size() % 2) > 0){ odd = true; } else{ odd = false; }
	}
	public void makeGames(){					//Automatically creates all games from the team list, currently does not have seeding
		for (int i = 0; i < (teamList.size() / 2); i++){
			makeGame(teamList.get(i * 2), teamList.get(i * 2 + 1));
		}
	}
	public void makeGame(Team one, Team two){
		Game game = new Game(one, two);
		gameList.add(game);
	}
	public ArrayList<Game> getGames(){			//Returns array list of games
		return gameList;
	}
	public boolean checkComplete(){				//Checks if all games are complete
		boolean complete = true;
		for (int i = 0; i < gameList.size(); i++){
			if (!gameList.get(i).isComplete()){complete = false;}
		}
		return complete;
	}
	public ArrayList<Team> getWinners(){		//Only call if all games are complete, returns all winners
		ArrayList<Team> winners = new ArrayList<Team>();
		for (int i = 0; i < gameList.size(); i++){
			winners.add(gameList.get(i).getWinner());
		}
		if (odd) {winners.add(teamList.get(teamList.size() - 1));}		//Adds the bye to the winners
		return winners;
	}
	public ArrayList<Team> getLosers(){		//Only call if all games are complete, returns all losers, useful for double elim
		ArrayList<Team> losers = new ArrayList<Team>();
		for (int i = 0; i < gameList.size(); i++){
			losers.add(gameList.get(i).getLoser());
		}
		return losers;
	}
}
