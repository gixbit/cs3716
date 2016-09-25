package Core;

import Actors.Organizer;
import Actors.Person;

public class Tournament {
	public Tournament() {
		
	}
	public Person GetOrganizer() {
		return null;
	}
	public Info GetInfo() {
		return null;
	}
	public Type GetType() {
		return null;
	}
	public void ChangeInfo(Person P, Info I) {
		if (P instanceof Organizer) {
			return;
		}
		return;
	}
}