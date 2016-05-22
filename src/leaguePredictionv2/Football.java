package leaguePredictionv2;


public class Football implements Sports {


	Tournament football = new Tournament();

	public void setHomeTeam() {
		football.inputParticipants();
		String randomHomeTeam;
		// Checking to see if the arraylist contains more than one team, if it
		// contains only one team we remove it so when setVisitingTeam class
		// calls the array its empty.
		if (football.getParticipants().size() == 1) {
			football.getParticipants().remove(0);
			System.out.println(football.getRandomTeam());
		} else if (football.getParticipants().size() == 0) {
			System.out.println(football.getRandomTeam());
		} else if (football.getParticipants().size() >= 2) {
			randomHomeTeam = football.getRandomTeam();
			System.out.println("the home team playing today is "
					+ randomHomeTeam);

			// Removing the home team from the ArrayList
			for (int j = 0; j < football.getParticipants().size(); j++) {
				String check = (String) football.getParticipants().get(j);
				if (randomHomeTeam == check) {
					football.getParticipants().remove(j);
					break;
				}
			}
		}
	}

	public void setVisitingTeam() {

		if (football.getParticipants().size() == 1) {
			int size = football.getParticipants().size();
			System.out.println("the Visiting team playing today is "
					+ football.getParticipants().get(0));
		} else if (football.getParticipants().size() == 0) {
			
		} else if (football.getParticipants().size() >= 2) {

			System.out.println("the Visiting team playing today is "
					+ football.getRandomTeam());

		}
	}

	public void getNumberOfPlayers() {
		if(football.getParticipants().size()>0)
		System.out.println("There are 11 players in each Team");

	}

}
