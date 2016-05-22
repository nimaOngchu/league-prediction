package leaguePredictionv2;

import java.io.IOException;
import java.util.Scanner;

public class Getinfo {

	static String sportType;
	static Scanner reader = new Scanner(System.in);
	

	static String readSportType() throws IOException {

		int attempt = 1;
		boolean check = true;
		System.out.println("Type the Sport Name football or basketball or cricket");
		do {

			try {
				sportType = reader.next();
				if (sportType.equalsIgnoreCase("football")
						|| sportType.equalsIgnoreCase("basketball")||sportType.equalsIgnoreCase("cricket")) {
					check = false;
				} 
				else if(sportType.contains("foot")){
					throw new IncorrectInputException("Did you want to select football ? if yes then please type football, if not type your desired sport");
				}
				else if(sportType.contains("basket")){
					throw new IncorrectInputException("Did you want to select basketball ? if yes then please type basketball, if not type your desired sport");
				}
				else if(sportType.contains("cric")){
					throw new IncorrectInputException("Did you want to select cricket ? if yes then please type cricket, if not type your desired sport");
				}
				else {
					throw new IncorrectInputException(
							"Please Type either football or basketball or cricket");
				}

			} catch (IncorrectInputException e) {
				attempt++;
				if (attempt < 4)
				System.out.println(e.getMessage());
					else
					System.out.println("I give up with");
			}
		} while ((check == true) && (attempt<4)) ;

		return sportType;

	}
}