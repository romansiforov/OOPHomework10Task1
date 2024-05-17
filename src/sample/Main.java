package sample;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		File file = new File("textFile.txt");
		
		TextAnalyzeService ta = new TextAnalyzeService();
		
		ta.buildCharFrequencyStatistics(file);
		
		System.out.println(ta.getCharStatistics());
		
		Comparator<Character> comp = new CharStatComparator(ta.getCharStatistics());
		
		SortedMap<Character, Integer> finalSortedStat = new TreeMap(comp);
		finalSortedStat.putAll(ta.getCharStatistics());
		System.out.println(finalSortedStat);
	}

}
