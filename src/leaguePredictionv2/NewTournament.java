package leaguePredictionv2;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class NewTournament {

	HashMap<String, ArrayList> storeScoresCricket = new HashMap();
	HashMap<String, Integer> storeScores = new HashMap();
	HashMap<String, Integer> storeWins = new HashMap();
	HashMap<String, Integer> storeTotalScores = new HashMap();
	TestInterfaceSports testInterfaceSports = new TestInterfaceSports();

	public void inputParticipants() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter name of the teams for the tournament");
		System.out.println("Type exit when you are done ");
		int i = 0;
		while (!input.hasNext("exit")) {
			String inputed = input.nextLine();

			/*
			 * BELOW we are using count (a hashmap ) so that we could store
			 * number of game won by respective teams. Team names are used as
			 * key and match won as the value in this hasmap. innitially the
			 * vaue of match won is set to zero.
			 */

			storeScores.put(inputed, 0);
			storeScoresCricket.put(inputed, new ArrayList());
			storeWins.put(inputed, 0);

			i++;
		}

	}

	public int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public void startLeague() {

		String winner="";
		int matchCount = 1;
		int wins=0;
		ArrayList<String> list = new ArrayList<String>(storeScores.keySet());

		for (int m = 0; m < list.size(); m++) {

			for (int k = 0; k < list.size(); k++) {

				if (k < m) {

					if (testInterfaceSports.getSport
							.equalsIgnoreCase("cricket")) {
						ArrayList<Integer> runsOvers = new ArrayList();

						// over
						runsOvers.add(getRandomNumberInRange(2, 20));

						// runs
						if (runsOvers.get(0) > 11) {
							runsOvers.add(getRandomNumberInRange(11, 720));
						} else {
							runsOvers.add(getRandomNumberInRange(
									runsOvers.get(0), 720));

							storeScoresCricket.put(list.get(k), runsOvers);

						}

						ArrayList<Integer> scoresOfK = storeScoresCricket
								.get(list.get(k));
						ArrayList<Integer> scoresOfM = storeScoresCricket
								.get(list.get(m));
						int runsOfK = scoresOfK.get(0);
						int oversOfK = scoresOfK.get(1);
						int runsOfM = scoresOfM.get(0);
						int oversOfM = scoresOfM.get(1);
						if (runsOfK > runsOfM) {
							winner = list.get(k);
						} else {
							winner = list.get(m);
						}
						
						
						storeWins.put(winner, wins+1);

				}
				// winner = twoTeamMAtch(m, k, participants);// geting winner
				// // rnadomly
				//
				// Integer matchWon = count.get(winner);
				// count.put(winner, matchWon + 1);
				System.out.println(" match " + matchCount + " "
				 + list.get(m) + " VS "
				+ list.get(k) + "--- " + winner + " wins " + wins + "game"
				 );
		 matchCount++;
				// }
			}

		}

//		System.out.println("---------------------------");
//		for (Map.Entry<String, Integer> e : count.entrySet()) {
//			System.out.println(e.getKey() + " won " + e.getValue() + " game");
//		}
//
//		System.out.println("---------------------------");
//		System.out.println("Sorted By Wins");
//		System.out.println("---------------------------");
//
//		SemifinalsAndFinal semifinalAndFinal = new SemifinalsAndFinal();
//		semifinalAndFinal.getSemifinalTeams(count);
//
//		System.out.println("---------------------------");
//		System.out.println("SEMIFINAL MATCH");
//
//		semifinalAndFinal.semifinalMatch();
//
//		System.out.println("---------------------------");
//		System.out.println("FINAL MATCH");
//
//		semifinalAndFinal.finalMatch();

	}

}}