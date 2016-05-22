package leaguePredictionv2;

public class Cricket implements Sports {

	Tournament cricket = new Tournament();

	public void setHomeTeam() {
		cricket.inputParticipants();
		String randomHomeTeam;
		// Checking to see if the arraylist contains more than one team, if it
		// contains only one team we remove it so when setVisitingTeam class
		// calls the array its empty.
		if (cricket.getParticipants().size() == 1) {
			cricket.getParticipants().remove(0);
			System.out.println(cricket.getRandomTeam());
		} else if (cricket.getParticipants().size() == 0) {
			System.out.println(cricket.getRandomTeam());
		} else if (cricket.getParticipants().size() >= 2) {
			randomHomeTeam = cricket.getRandomTeam();
			System.out.println("the home team playing today is "
					+ randomHomeTeam);

			// Removing the home team from the ArrayList
			for (int j = 0; j < cricket.getParticipants().size(); j++) {
				String check = (String) cricket.getParticipants().get(j);
				if (randomHomeTeam == check) {
					cricket.getParticipants().remove(j);
					break;
				}
			}
		}
	}

	public void setVisitingTeam() {

		if (cricket.getParticipants().size() == 1) {
			int size = cricket.getParticipants().size();
			System.out.println("the Visiting team playing today is "
					+ cricket.getParticipants().get(0));
		} else if (cricket.getParticipants().size() == 0) {
			
		} else if (cricket.getParticipants().size() >= 2) {

			System.out.println("the Visiting team playing today is "
					+ cricket.getRandomTeam());

		}
	}

	public void getNumberOfPlayers() {
		if(cricket.getParticipants().size()>0)
		System.out.println("There are 11 players in each Team");

	}
}