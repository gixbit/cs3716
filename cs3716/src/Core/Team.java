package Core;

import Actors.Person;

public class Team {
	private Person[] Roster;
	public Team(Person ... persons) {
		this.Roster = persons;
	}
}