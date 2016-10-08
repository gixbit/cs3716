package Core;

import Actors.Organizer;
import Rules.Rules;

public class Tournament {
	private String Name;
	private String Date;
	private Rules Rules;
	private Organizer Organizer;
	public Tournament(Organizer o,String name, String date) {
		this.Name = name;
		this.Date = date;
		this.Organizer = o;
	}
	public Organizer GetOrganizer() {
		return this.Organizer;
	}
	public String GetName() {
		return this.Name;
	}
	public String GetDate() {
		return this.Date;
	}
	public void AddTeam(Team t) {
		Rules.AddTeam(t);
	}
	public Rules GetType() {
		return this.Rules;
	}
	public void BroadCast() {
		//Send Details
	}
}