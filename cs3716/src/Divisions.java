import java.util.ArrayList;

/**
 * 
 * @author John Hollett
 * @author Keir Strickland Murphy
 * @author Rory Campbell
 * @author Jaimee Bessey
 * @author Kristan James Hart
 */
public class Divisions implements Structure {
	private ArrayList<Bracket> bList = new ArrayList<Bracket>();
	private int bNumber;
	private boolean finalStart = false;
	private SingleElimination finals;
	
	private ArrayList<Team> winners = new ArrayList<Team>();
	
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
		if (!finalStart) {return bList;} else {return finals.getBrackets();}
	}

	@Override
	public void advanceTournament() {
		if (bList.size() > 0){
		
		ArrayList<Bracket> remove = new ArrayList<Bracket>();
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
				
								//This is where I need to combine brackets if needed
				if (bList.get(i).getWinners().size() == 1){
					winners.add(bList.get(i).getWinners().get(0));
					remove.add(bList.get(i));
				}else{
					bList.set(i, new Bracket(bList.get(i).getWinners() ));
					bList.get(i).makeGames();
				}
			}
			for (int z = 0; z < remove.size(); z++){
				//System.out.println(remove.get(z));
				bList.remove(remove.get(z));
				bList.trimToSize();
				//System.out.println("Size after trim: " + bList.size());
				
			}
		}
		}else{
			if (!finalStart){
				finals = new SingleElimination(winners);
				finalStart = true;
				//bList = finals.getBrackets(); Don't think I need to do this
			}else{
				finals.advanceTournament();
			}
		}
		
	}

}
