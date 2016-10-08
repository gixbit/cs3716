package Core;

import Actors.*;

public class Team {
	private String Name;
	private User[] Roster;
	private Coach Coach;
	private Tournament Tournament;
	public Team(String name, Coach c, Tournament T, User ... players) {
		this.Name = name;
		this.Roster = players;
		this.Coach = c;
		this.Tournament = T;
	}
	public Coach GetCoach() {
		return this.Coach;
	}
	public Tournament GetTournament() {
		return this.Tournament;
	}
	public User[] GetRoster() {
		return this.Roster;
	}
}