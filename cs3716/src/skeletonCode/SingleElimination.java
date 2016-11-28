package skeletonCode;

import java.util.ArrayList;

public class SingleElimination implements Structure{
	private ArrayList<Bracket> bList = new ArrayList<Bracket>();;
	
	public SingleElimination(ArrayList<Team> teamList){
		createBrackets(teamList);
		bList.get(0).makeGames();
	}
	
	@Override
	public void createBrackets(ArrayList<Team> teamList) {
		bList.add(new Bracket(teamList));
	}
	@Override
	public ArrayList<Bracket> getBrackets(){
		return bList;
	}

	@Override
	public void advanceTournament() {
		boolean complete = true;
		for (int i = 0; i < bList.size(); i++){
			if (!bList.get(i).checkComplete()){complete = false;}
		}
		if (complete){
			for (int i = 0; i < bList.size(); i++){
				for (int j = 0; j < bList.get(i).getGames().size(); j++){
					bList.get(i).getGames().get(j).getWinner().win();
					bList.get(i).getGames().get(j).getWinner().addPoints(bList.get(i).getGames().get(j).getWinnerScore());

					bList.get(i).getGames().get(j).getLoser().addPoints(bList.get(i).getGames().get(j).getLoserScore());
				}
				bList.set(i, new Bracket(bList.get(i).getWinners() ));
				bList.get(i).makeGames();
			}
			
		}
	}

}
