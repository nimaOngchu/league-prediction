package leaguePredictionv2;

import java.awt.List;
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

public class Tournament {
	protected LinkedList<String> participants = new LinkedList<String>();

	HashMap<String, Integer> count = new HashMap<String, Integer>();

	public void inputParticipants() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter name of the teams for the tournament");
		System.out.println("Type exit when you are done ");
		int i = 0;
		while (!input.hasNext("exit")) {

			participants.add(i, input.nextLine());
			/*
			 * BELOW we are using count (a hashmap ) so that we could store
			 * number of game won by respective teams. Team names are used as key
			 * and match won as the value in this hasmap. innitially the vaue of
			 * match won is set to zero.
			 */
			count.put(participants.get(i), 0);

			i++;
		}

	}

	public LinkedList getParticipants() {
		return participants;

	}

	/*
	 * getRamdomTeam() method is being used only in football,basketball and
	 * cricket class for generating home and visiting teams
	 */
	public String getRandomTeam() {
		Random randomN = new Random();
		String randomTeam;
		int arraySize = participants.size();
		if (participants.size() > 1) {
			randomTeam = participants.get(randomN.nextInt(arraySize));

		} else
			randomTeam = "You should have at least 2 teams for the tournament";
		return randomTeam;
	}

	/*
	 * twoTeamMatch() method is being used to generate random winner from a
	 * given two teams.
	 */
	public String twoTeamMAtch(int m, int k, LinkedList<String> input) {
		LinkedList<String> teamsToPlay = new LinkedList<String>();
		Random randomWinner = new Random();
		teamsToPlay.add(input.get(m));
		teamsToPlay.add(input.get(k));
		String theWinner = teamsToPlay.get(randomWinner.nextInt(2));
		return theWinner;

	}

	public void startLeague() {
		
		String winner;
		int matchCount = 1;

		for (int m = 0; m < participants.size(); m++) {

			for (int k = 0; k < participants.size(); k++) {

				if (k < m) {
					winner = twoTeamMAtch(m, k, participants);// geting winner
																// rnadomly

					Integer matchWon = count.get(winner);
					count.put(winner, matchWon + 1);
					System.out.println(" match " + matchCount + " "
							+ participants.get(m) + " VS "
							+ participants.get(k) + "--- " + winner + " wins "
							+ count.get(winner) + " game");
					matchCount++;
				}
			}

		}

		System.out.println("---------------------------");
		for (Map.Entry<String, Integer> e : count.entrySet()) {
			System.out.println(e.getKey() + " won " + e.getValue() + " game");
		}

		System.out.println("---------------------------");
		System.out.println("Sorted By Wins");
		System.out.println("---------------------------");
		
		SemifinalsAndFinal semifinalAndFinal=new SemifinalsAndFinal();
		semifinalAndFinal.getSemifinalTeams(count);
		
		System.out.println("---------------------------");
		System.out.println("SEMIFINAL MATCH");
		
		semifinalAndFinal.semifinalMatch();

		System.out.println("---------------------------");
		System.out.println("FINAL MATCH");

		semifinalAndFinal.finalMatch();

	}

}