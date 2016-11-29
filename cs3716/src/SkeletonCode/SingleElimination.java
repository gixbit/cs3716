package SkeletonCode;
import java.util.ArrayList;

/**
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
<<<<<<< HEAD
=======
 * @author Karl Chiasson
>>>>>>> refs/remotes/origin/jaimeeThursdayNov24
 */
public class SingleElimination implements Structure{
	/**
	 * List of brackets this Single Elimination holds
	 */
	private ArrayList<Bracket> bList = new ArrayList<Bracket>();
	/**
	 * Constructor for a single elimination
	 * @param teamList
	 */
	public SingleElimination(ArrayList<Team> teamList){
		createBrackets(teamList);
		this.bList.get(0).makeGames();
	}
	
	@Override
	public void createBrackets(ArrayList<Team> teamList) {
		this.bList.add(new Bracket(teamList));
	}
	@Override
	public ArrayList<Bracket> getBrackets(){
		return this.bList;
	}

	@Override
	public void advanceTournament() {
		boolean complete = true;
		for (int i = 0; i < this.bList.size(); i++){
			if (!this.bList.get(i).checkComplete()){complete = false;}
		}
		if (complete){
			for (int i = 0; i < this.bList.size(); i++){
				for (int j = 0; j < this.bList.get(i).getGames().size(); j++){
					this.bList.get(i).getGames().get(j).getWinner().win();
					this.bList.get(i).getGames().get(j).getWinner().addPoints(this.bList.get(i).getGames().get(j).getWinnerScore());

					this.bList.get(i).getGames().get(j).getLoser().addPoints(this.bList.get(i).getGames().get(j).getLoserScore());
				}
				this.bList.set(i, new Bracket(this.bList.get(i).getWinners() ));
				this.bList.get(i).makeGames();
			}
			
		}
	}

}
