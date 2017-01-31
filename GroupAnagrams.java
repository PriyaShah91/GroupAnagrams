import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {

public static void main(String[] args) throws FileNotFoundException  {
	findAnagrams(args[0]);
}

public static void findAnagrams(String path) throws FileNotFoundException{
	Scanner sc = new Scanner(new File(path));
	
	// Build a HashMap while reading words from a file
	HashMap<String, String> wordMap = new HashMap<String, String>();
	
	while (sc.hasNextLine()) {
		String originalWord = sc.nextLine().trim();
		
		// convert a string into a character array and sort it
		char wordArray[] = originalWord.toCharArray();
		Arrays.sort(wordArray);
		
		// Use the sorted word as a key in the HashMap and store the original word corresponding to the key
		String sortedWord =  new String(wordArray);
		
		// if more than one word exist with the same key, concatenate them
		if(wordMap.containsKey(sortedWord)){
			wordMap.put(sortedWord,wordMap.get(sortedWord)+(", ").concat(originalWord));
		}
		else
			wordMap.put(sortedWord, originalWord);
	  }
	
	sc.close();
	
	// Retrieve the values that contain a "," as comma would mean that anagram words exist
	for(Map.Entry<String, String> e : wordMap.entrySet()){
		if(e.getValue().indexOf(",") != -1)
			System.out.println(e.getValue());
		}
	}
}
