import java.util.ArrayList;

public class Tournament {
	private String startDate;			//Start and end dates are when one is allowed to register for the tournament
	private String endDate;
	private int tType;
	private String tournamentName;
	private ArrayList<Team> teamList = new ArrayList<Team>();

	public Tournament(String name, String sDate, String eDate, int structure){
		startDate = sDate;
		endDate = eDate;
		tournamentName = name;
		tType = structure;
	}
	
	public String getName(){
		return tournamentName;
	}
	public void setName(String name){
		tournamentName = name;
	}
	public String getStartDate(){
		return startDate;
	}
	public void setStartDate(String date){
		startDate = date;
	}
	public String getEndDate(){
		return endDate;
	}
	public void setEndDate(String date){
		endDate = date;
	}
	public void addTeam(Team team){
		teamList.add(team);
	}
	public ArrayList<Team> getTeamList(){
		return teamList;
	}
	public int getType(){
		return tType;
	}
	public void setType(int t){
		tType = t;
	}
	
}
