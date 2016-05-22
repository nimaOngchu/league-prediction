package leaguePredictionv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Basketball implements Sports {

	Tournament basketball = new Tournament();

	public void setHomeTeam() {
		basketball.inputParticipants();
		String randomHomeTeam;
		// Checking to see if the arraylist contains more than one team, if it
		// contains only one team we remove it so when setVisitingTeam class
		// calls the array its empty.
		if (basketball.getParticipants().size() == 1) {
			basketball.getParticipants().remove(0);
			System.out.println(basketball.getRandomTeam());
		} else if (basketball.getParticipants().size() == 0) {
			System.out.println(basketball.getRandomTeam());
		} else if (basketball.getParticipants().size() >= 2) {
			randomHomeTeam = basketball.getRandomTeam();
			System.out.println("the home team playing today is "
					+ randomHomeTeam);

			// Removing the home team from the ArrayList
			for (int j = 0; j < basketball.getParticipants().size(); j++) {
				String check = (String) basketball.getParticipants().get(j);
				if (randomHomeTeam == check) {
					basketball.getParticipants().remove(j);
					break;
				}
			}
		}
	}

	public void setVisitingTeam() {

		if (basketball.getParticipants().size() == 1) {
			int size = basketball.getParticipants().size();
			System.out.println("the Visiting team playing today is "
					+ basketball.getParticipants().get(0));
		} else if (basketball.getParticipants().size() == 0) {
			
		} else if (basketball.getParticipants().size() >= 2) {

			System.out.println("the Visiting team playing today is "
					+ basketball.getRandomTeam());

		}
	}

	public void getNumberOfPlayers() {
		if(basketball.getParticipants().size()>0)
		System.out.println("There are 5 players in each Team");

	}
}
