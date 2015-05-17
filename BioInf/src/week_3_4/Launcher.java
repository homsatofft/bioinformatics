package week_3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

public class Launcher {
public static void main(String[] args) {
	List<String> dnaStrings = new ArrayList<>(Arrays.asList(
			"ATGAGGTC", 
			"GCCCTAGA", 
			"AAATAGAT",
			"TTGTGCTA"));
	List<String> motifs = new ArrayList<>(Arrays.asList(
			"GTC", 
			"CCC", 
			"ATA",
			"GCT"));
	Profile p = new Profile(motifs, true);
	List<String> newMotifs = p.motifs(dnaStrings);
	System.out.println(Utils.collectionToString(newMotifs));
}
}
