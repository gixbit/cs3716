import java.util.Scanner;		//Just testing stuff


public class Tester {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		String sDate = scan.nextLine();
		String eDate = scan.nextLine();
		int structure = scan.nextInt();
		
//		System.out.println(name + "; " + sDate + "; " + eDate + "; " + structure);
		
		Tournament t = new Tournament(name, sDate, eDate, structure);
		Team team1 = new Team("Team1");
		Team team2 = new Team("Team2");
		Team team3 = new Team("Team3");
		Team team4 = new Team("Team4");
		
		t.addTeam(team1);
		t.addTeam(team2);
		t.addTeam(team3);
		t.addTeam(team4);
		
		if (t.getType() != 0){
			
		}
		
		Bracket b = new Bracket(t.getTeamList());
		b.makeGames();
		for (int i = 0; i < 2; i++){
			b.getGames().get(i).setScoreOne(15);
			b.getGames().get(i).setScoreTwo(13);
			b.getGames().get(i).completeGame();	
		}
		System.out.println(b.getWinners().get(0).getTeamName() + " "  + b.getWinners().get(1).getTeamName());
		
		b = new Bracket(b.getWinners());
		b.makeGames();
		b.getGames().get(0).setScoreOne(15);
		b.getGames().get(0).setScoreTwo(13);
		b.getGames().get(0).completeGame();
		
		System.out.println(b.getWinners().get(0).getTeamName());
	}
}
