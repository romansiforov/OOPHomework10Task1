package sample;

import java.util.Comparator;
import java.util.SortedMap;

public class CharStatComparator implements Comparator<Character>{
	
	SortedMap<Character,Integer> stat;
	
	public CharStatComparator(SortedMap<Character,Integer> stat) {
		this.stat = stat;
	}

	@Override
	public int compare(Character o1, Character o2) {
		
		Integer param1 = stat.get(o1);
		Integer param2 = stat.get(o2);
		
		if(param1 > param2) {
			return 1;
		}
		if(param1 < param2) {
			return -1;
		}
		
		return 0;
	}

}
