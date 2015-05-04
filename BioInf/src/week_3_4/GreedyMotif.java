package week_3_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GreedyMotif {
	public Collection<String> search(List<String> dna, int k, int t) {
		List<String> bestMotifs = new ArrayList<>();
		for (String dnaString : dna) {
			String motif = dnaString.substring(0, k);
			bestMotifs.add(motif);
		}
		String line = dna.get(0);
		for (int i = 0; i <= line.length() - k; i++) {
			List<String> _profileMotifs = new ArrayList<>();
			String _motif = line.substring(i, i + k);
			_profileMotifs.add(_motif);
			for (int j = 1; j < t; j++) {
				Profile p = new Profile(_profileMotifs);
				String __motif = p.findPattern(dna.get(j));
				_profileMotifs.add(__motif);
			}
			System.out.println(score(_profileMotifs));
			if (score(_profileMotifs) < score(bestMotifs)) {
				bestMotifs = _profileMotifs;
			}
		}
		return bestMotifs;
	}

	int score(List<String> motif) {
		int score = 0;
		for (int j = 0; j < motif.get(0).length(); j++) {
			List<Character> chars = new ArrayList<>();
			for (int i = 0; i < motif.size(); i++) {
				chars.add(motif.get(i).charAt(j));
			}
			Collections.sort(chars);
			char _c = 'A';
			int max = 0;
			int _score = 0;
			for (char c : chars) {
				if (c != _c) {
					_score = Math.max(max, _score);
					max = 1;
					_c = c;
				} else {
					max++;
				}
			}
			_score = Math.max(max, _score);
			score += motif.size() - _score;
		}
		return score;
	}
}
