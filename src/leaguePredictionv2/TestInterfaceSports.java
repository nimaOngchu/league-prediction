package leaguePredictionv2;

import java.io.IOException;

public class TestInterfaceSports {

	static String getSport;
	

	public static void main(String[] args) throws IncorrectInputException, IOException {

		getSport = Getinfo.readSportType();
		 Tournament league=new Tournament();
		 NewTournament newLeague=new NewTournament();
		 
		

		if (getSport.equalsIgnoreCase("football"))

		{
			System.out.println("you have chosen " + getSport);
//			Football f = new Football();
//			f.setHomeTeam();
//			f.setVisitingTeam();
//			f.getNumberOfPlayers();
			league.inputParticipants();
			if(league.participants.size()<4){
				System.out.println("There Should be at least four team for a league match, please insert four or more teams");
			}
			else
			league.startLeague();
		}
		 else if (getSport.equalsIgnoreCase("basketball")) {
			System.out.println("you have chosen " + getSport);
			league.inputParticipants();
			if(league.participants.size()<4){
				System.out.println("There Should be at least four team for a league match, please insert four or more teams");
			}
			else
			league.startLeague();
			
//			Basketball b = new Basketball();
//			b.setHomeTeam();
//			b.setVisitingTeam();
//			b.getNumberOfPlayers();
//			
//		
		} 
			else if (getSport.equalsIgnoreCase("cricket")) {
			System.out.println("you have chosen " + getSport);
			league.inputParticipants();
			if(league.participants.size()<4){
				System.out.println("There Should be at least four team for a league match, please insert four or more teams");
			}
			else
			newLeague.startLeague();
			
//			Cricket c = new Cricket();
//			c.setHomeTeam();
//			c.setVisitingTeam();
//			c.getNumberOfPlayers();
//
		}
//
}
}
