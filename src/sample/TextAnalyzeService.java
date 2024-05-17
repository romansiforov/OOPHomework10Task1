package sample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class TextAnalyzeService {

	private SortedMap<Character, Integer> charStatistics;
	
	public TextAnalyzeService() {
		charStatistics = new TreeMap<>();
	}
	
	
	public SortedMap<Character, Integer> getCharStatistics() {
		return charStatistics;
	}


	public void setCharStatistics(SortedMap<Character, Integer> charStatistics) {
		this.charStatistics = charStatistics;
	}

	@Override
	public String toString() {
		return "TextAnalyzeService [charStatistics=" + charStatistics + "]";
	}


	private String getTextFromFile(File file) throws IOException{
		String result = "";
		try(Reader rd = new FileReader(file)){
			char[] chars = new char[3000];
			int readChars = 0;
			for(;;) {
				readChars = rd.read(chars);
				if(readChars <= 0) {
					break;
				}
				result+= new String(chars, 0, readChars);
			}
		}
		return result.replaceAll("\\s", "");
	}
	
	private int countChars(char character, char[] array) {
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			if(character == array[i]) {
				counter++;
			}
		}
		return counter;
		
	}
	
	public void buildCharFrequencyStatistics(File file) {
		char[] tmp;
		try {
			tmp = getTextFromFile(file).toCharArray();
			for(int i = 0; i < tmp.length; i++) {
				charStatistics.putIfAbsent(tmp[i], countChars(tmp[i], tmp));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
