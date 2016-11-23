import java.util.ArrayList;

public class Divisions implements Structure {
	private ArrayList<Bracket> bList = new ArrayList<Bracket>();
	int bNumber;
	
	public Divisions(ArrayList<Team> teamList, int i){
		bNumber = i;
		int peoplePerBracket = teamList.size() / i;
		int remainder = teamList.size() % i;
		for (int j = 0; j < i; j++){
			ArrayList<Team> tList = new ArrayList<Team>();
			for (int k = 0 ; k < peoplePerBracket ; k++){
				tList.add(teamList.get(k + (j * peoplePerBracket)));
			}
			if (remainder > 0){
				tList.add(teamList.get(teamList.size() - 1));
				tList.remove(teamList.size() - 1);
				remainder--;
			}
			createBrackets(tList);
		}
		for (int q = 0; q < bList.size(); q++){
			bList.get(q).makeGames();
		}
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
