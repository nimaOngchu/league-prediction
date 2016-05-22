package leaguePredictionv2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class SemifinalsAndFinal {

	Tournament t = new Tournament();
	LinkedList<String> semifinalTeams = new LinkedList<String>();
	LinkedList<String> TeamsInFinal = new LinkedList<String>();

	public void getSemifinalTeams(HashMap<String, Integer> k) {

		/*
		 * passing the hashmpa into a linked list for sorting purpose so that we
		 * could find top four and make them in the semifinals
		 */
		LinkedList<Entry<String, Integer>> list = new LinkedList<>(k.entrySet());
		/* sorting with game won */
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<String, Integer> result = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
			System.out.println(entry.getKey() + " won " + entry.getValue()
					+ " game");
		}

		System.out.println("---------------------------");
		System.out.println("Following are the Four teams in the Semifinals");
		System.out.println("---------------------------");

		int counter = 1;

		for (Map.Entry<String, Integer> e : result.entrySet()) {
			if (counter > 4)
				break;
			System.out
					.println(e.getKey() + " ------ " + e.getValue() + " wins");
			semifinalTeams.add(e.getKey());
			counter++;
		}
	}

	public void semifinalMatch() {

		for (int i = 0; i < 2; i++) {
			String semifinalWinner = t.twoTeamMAtch(i, i + 2, semifinalTeams);

			System.out.println(semifinalTeams.get(i) + " vs "
					+ semifinalTeams.get(i + 2) + " -- " + semifinalWinner
					+ " wins");
			TeamsInFinal.add(semifinalWinner);
		}
	}

	public void finalMatch() {
		String WinnerOfLeague = t.twoTeamMAtch(0, 1, TeamsInFinal);
		System.out.println(TeamsInFinal.get(0) + " vs " + TeamsInFinal.get(1)
				+ " --- " + WinnerOfLeague + " wins");

		System.out.println("THE WINNER OF THE TOURNAMENT IS " + WinnerOfLeague);
	}
}
