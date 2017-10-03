import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class readFiles {
	
	Map<String, Integer> frequency = new HashMap<>();
	Map<String, Integer> mentionsMap = new HashMap<>();
	Map<String, Integer> topicsMap = new HashMap<>();
	Map<String, Integer> identifiersMap = new HashMap<>();
	Map<String, Integer> referencesMap = new HashMap<>();
	
	ArrayList<String> mentions= new ArrayList();
	ArrayList<String> topics = new ArrayList();
	ArrayList<String> identifiers = new ArrayList();
	ArrayList<String> references = new ArrayList();
	
	Map<String, Integer> frequency1 = new HashMap<>();
	Map<String, Integer> mentionsMap1 = new HashMap<>();
	Map<String, Integer> topicsMap1 = new HashMap<>();
	Map<String, Integer> identifiersMap1 = new HashMap<>();
	Map<String, Integer> referencesMap1 = new HashMap<>();
	
	ArrayList<String> mentions1= new ArrayList();
	ArrayList<String> topics1 = new ArrayList();
	ArrayList<String> identifiers1 = new ArrayList();
	ArrayList<String> references1 = new ArrayList();
	
	Map<String, Integer> frequency2 = new HashMap<>();
	Map<String, Integer> mentionsMap2 = new HashMap<>();
	Map<String, Integer> topicsMap2 = new HashMap<>();
	Map<String, Integer> identifiersMap2 = new HashMap<>();
	Map<String, Integer> referencesMap2 = new HashMap<>();
	
	ArrayList<String> mentions2= new ArrayList();
	ArrayList<String> topics2 = new ArrayList();
	ArrayList<String> identifiers2 = new ArrayList();
	ArrayList<String> references2 = new ArrayList();
	
	Map<String, Integer> frequency3 = new HashMap<>();
	Map<String, Integer> mentionsMap3 = new HashMap<>();
	Map<String, Integer> topicsMap3 = new HashMap<>();
	Map<String, Integer> identifiersMap3 = new HashMap<>();
	Map<String, Integer> referencesMap3 = new HashMap<>();
	
	ArrayList<String> mentions3= new ArrayList();
	ArrayList<String> topics3 = new ArrayList();
	ArrayList<String> identifiers3 = new ArrayList();
	ArrayList<String> references3 = new ArrayList();
	
	 String folderLocation = File.separator + "Users" + File.separator + "Brendan"
			+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + File.separator + "testFiles";
	
	 File[] files = new File(folderLocation).listFiles();
	 
	 String location1 = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test.txt";
	 
	 String location2 = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test2.txt";
	 
	 String location3 = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test3.txt";
			 
	 
	 //String filePath = "";

	public void parseWords() throws IOException {
	
		
		for(File file : files) {
			
			//use bufferedreader that will read file
				
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
				
			String line = reader.readLine();

				while(line != null){
					
					if (!line.trim().equals("")) {
						//splitting words by spaces between them
						String[] words = line.split(" ");
					
						//iterating through each word in the array of words
						for (String word : words) {
							
							//in case the word is null or an empty space we just want to continue
							if (word == null || word.trim().equals("")) {
								continue;
							}
							
							//to ensure that capital letters don't impact the counting
							String processed = word.toLowerCase();
							
							char firstLetter = processed.charAt(0);
							
							//get the frequency of each word
							if (frequency.containsKey(processed)) {
								frequency.put(processed, frequency.get(processed) +1);
							}
							else {
								frequency.put(processed, 1);
							}
							
							//separating all the identifying words
							if (firstLetter == '@') {
								mentions.add(processed);
							}
							else if (firstLetter == '#') {
								topics.add(processed);
							}
							else if (firstLetter == '!') {
								identifiers.add(processed);
							}
							else if (firstLetter == '^') {
								references.add(processed);
							}
						}
					}
					line = reader.readLine();
				}
				//now iterate through the ArrayLists and add the word to the map and increment its value by one
				for (String a: mentions) {
					if (mentionsMap.containsKey(a)) {
						mentionsMap.put(a, mentionsMap.get(a) +1);
					}
					else {
						mentionsMap.put(a, 1);
					}
				}
				
				for (String b: topics) {
					if (topicsMap.containsKey(b)) {
						topicsMap.put(b, topicsMap.get(b) +1);
					}
					else {
						topicsMap.put(b, 1);
					}
				}
				for (String c: identifiers) {
					if (identifiersMap.containsKey(c)) {
						identifiersMap.put(c, identifiersMap.get(c) +1);
					}
					else {
						identifiersMap.put(c, 1);
					}
				}
				for (String d: references) {
					if (referencesMap.containsKey(d)) {
						referencesMap.put(d, referencesMap.get(d) +1);
					}
					else {
						referencesMap.put(d, 1);
					}
				}
			}
		}
	
	
public void parseWords1() throws IOException {
	
		
		//for(File file : files) {
			
			//use bufferedreader that will read file
				
			
			BufferedReader reader = new BufferedReader(new FileReader(location1));
				
			String line = reader.readLine();

				while(line != null){
					
					if (!line.trim().equals("")) {
						//splitting words by spaces between them
						String[] words = line.split(" ");
					
						//iterating through each word in the array of words
						for (String word : words) {
							
							//in case the word is null or an empty space we just want to continue
							if (word == null || word.trim().equals("")) {
								continue;
							}
							
							//to ensure that capital letters don't impact the counting
							String processed = word.toLowerCase();
							
							char firstLetter = processed.charAt(0);
							
							//get the frequency of each word
							if (frequency1.containsKey(processed)) {
								frequency1.put(processed, frequency1.get(processed) +1);
							}
							else {
								frequency1.put(processed, 1);
							}
							
							//separating all the identifying words
							if (firstLetter == '@') {
								mentions1.add(processed);
							}
							else if (firstLetter == '#') {
								topics1.add(processed);
							}
							else if (firstLetter == '!') {
								identifiers1.add(processed);
							}
							else if (firstLetter == '^') {
								references1.add(processed);
							}
						}
					}
					line = reader.readLine();
				}
				//now iterate through the ArrayLists and add the word to the map and increment its value by one
				for (String a: mentions1) {
					if (mentionsMap1.containsKey(a)) {
						mentionsMap1.put(a, mentionsMap1.get(a) +1);
					}
					else {
						mentionsMap1.put(a, 1);
					}
				}
				
				for (String b: topics1) {
					if (topicsMap1.containsKey(b)) {
						topicsMap1.put(b, topicsMap1.get(b) +1);
					}
					else {
						topicsMap1.put(b, 1);
					}
				}
				for (String c: identifiers1) {
					if (identifiersMap1.containsKey(c)) {
						identifiersMap1.put(c, identifiersMap1.get(c) +1);
					}
					else {
						identifiersMap1.put(c, 1);
					}
				}
				for (String d: references1) {
					if (referencesMap1.containsKey(d)) {
						referencesMap1.put(d, referencesMap1.get(d) +1);
					}
					else {
						referencesMap1.put(d, 1);
					}
				}
			}
		
	
	
	
public void parseWords2() throws IOException {
	
	
	//for(File file : files) {
		
		//use bufferedreader that will read file
			
		
		BufferedReader reader = new BufferedReader(new FileReader(location2));
			
		String line = reader.readLine();

			while(line != null){
				
				if (!line.trim().equals("")) {
					//splitting words by spaces between them
					String[] words = line.split(" ");
				
					//iterating through each word in the array of words
					for (String word : words) {
						
						//in case the word is null or an empty space we just want to continue
						if (word == null || word.trim().equals("")) {
							continue;
						}
						
						//to ensure that capital letters don't impact the counting
						String processed = word.toLowerCase();
						
						char firstLetter = processed.charAt(0);
						
						//get the frequency of each word
						if (frequency2.containsKey(processed)) {
							frequency2.put(processed, frequency2.get(processed) +1);
						}
						else {
							frequency2.put(processed, 1);
						}
						
						//separating all the identifying words
						if (firstLetter == '@') {
							mentions2.add(processed);
						}
						else if (firstLetter == '#') {
							topics2.add(processed);
						}
						else if (firstLetter == '!') {
							identifiers2.add(processed);
						}
						else if (firstLetter == '^') {
							references2.add(processed);
						}
					}
				}
				line = reader.readLine();
			}
			//now iterate through the ArrayLists and add the word to the map and increment its value by one
			for (String a: mentions2) {
				if (mentionsMap2.containsKey(a)) {
					mentionsMap2.put(a, mentionsMap2.get(a) +1);
				}
				else {
					mentionsMap2.put(a, 1);
				}
			}
			
			for (String b: topics2) {
				if (topicsMap2.containsKey(b)) {
					topicsMap2.put(b, topicsMap2.get(b) +1);
				}
				else {
					topicsMap2.put(b, 1);
				}
			}
			for (String c: identifiers2) {
				if (identifiersMap2.containsKey(c)) {
					identifiersMap2.put(c, identifiersMap2.get(c) +1);
				}
				else {
					identifiersMap2.put(c, 1);
				}
			}
			for (String d: references2) {
				if (referencesMap2.containsKey(d)) {
					referencesMap2.put(d, referencesMap2.get(d) +1);
				}
				else {
					referencesMap2.put(d, 1);
				}
			}
		}
	
public void parseWords3() throws IOException {
	
	
	//for(File file : files) {
		
		//use bufferedreader that will read file
			
		
		BufferedReader reader = new BufferedReader(new FileReader(location3));
			
		String line = reader.readLine();

			while(line != null){
				
				if (!line.trim().equals("")) {
					//splitting words by spaces between them
					String[] words = line.split(" ");
				
					//iterating through each word in the array of words
					for (String word : words) {
						
						//in case the word is null or an empty space we just want to continue
						if (word == null || word.trim().equals("")) {
							continue;
						}
						
						//to ensure that capital letters don't impact the counting
						String processed = word.toLowerCase();
						
						char firstLetter = processed.charAt(0);
						
						//get the frequency of each word
						if (frequency3.containsKey(processed)) {
							frequency3.put(processed, frequency3.get(processed) +1);
						}
						else {
							frequency3.put(processed, 1);
						}
						
						//separating all the identifying words
						if (firstLetter == '@') {
							mentions3.add(processed);
						}
						else if (firstLetter == '#') {
							topics3.add(processed);
						}
						else if (firstLetter == '!') {
							identifiers3.add(processed);
						}
						else if (firstLetter == '^') {
							references3.add(processed);
						}
					}
				}
				line = reader.readLine();
			}
			//now iterate through the ArrayLists and add the word to the map and increment its value by one
			for (String a: mentions3) {
				if (mentionsMap3.containsKey(a)) {
					mentionsMap3.put(a, mentionsMap3.get(a) +1);
				}
				else {
					mentionsMap3.put(a, 1);
				}
			}
			
			for (String b: topics3) {
				if (topicsMap3.containsKey(b)) {
					topicsMap3.put(b, topicsMap3.get(b) +1);
				}
				else {
					topicsMap3.put(b, 1);
				}
			}
			for (String c: identifiers3) {
				if (identifiersMap3.containsKey(c)) {
					identifiersMap3.put(c, identifiersMap3.get(c) +1);
				}
				else {
					identifiersMap3.put(c, 1);
				}
			}
			for (String d: references3) {
				if (referencesMap3.containsKey(d)) {
					referencesMap3.put(d, referencesMap3.get(d) +1);
				}
				else {
					referencesMap3.put(d, 1);
				}
			}
		}
	
	
	
	
	public File[] getFiles() {
		return files;
	}
	
	/*public void getFileFolderAll() {
		fileFolder = files;
	}*/
	
	public Set<String> getFrequency() {
		return frequency.keySet();
	}
	
	public int getLength() {
		return files.length;
	}
	public void printLength() {
		System.out.println("There are " + files.length + " files in this folder.");
	}
	
	public void printFileNames() {
		//System.out.println("The file names are as follows: ");
		for (File file : files ) {
			System.out.print(file.getName() +"\n");
		}
	}
	
	public void printAllIdentifiers() {
		System.out.println("\nThere are four specific identifiers located in these files.");
		System.out.println("They are as follows: (@ : mentions; # : topics; ! : unique identifier; ^ : reference)\n");
	}
	
	public void printMentions() {
		//System.out.println("The number of mentions in this folder are: " );
		for(Entry<String, Integer> entry : mentionsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics() {
		//System.out.println("\nThe number of topics in this folder are: " );
		for(Entry<String, Integer> entry : topicsMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers() {
		//System.out.println("\nThe number of identifiers in this folder are: " );
		for(Entry<String, Integer> entry : identifiersMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences() {
		//System.out.println("\nThe number of references in this folder are: " );
		for(Entry<String, Integer> entry : referencesMap.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printFrequency() {
		/*for (String word : frequency.keySet()) {
			System.out.println(frequency.get(word) + " : " + frequency.);
		}*/
		System.out.println(frequency);
	}
	
	
	
	
	public void printMentions1() {
		//System.out.println("The number of mentions in this folder are: " );
		for(Entry<String, Integer> entry : mentionsMap1.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics1() {
		//System.out.println("\nThe number of topics in this folder are: " );
		for(Entry<String, Integer> entry : topicsMap1.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers1() {
		//System.out.println("\nThe number of identifiers in this folder are: " );
		for(Entry<String, Integer> entry : identifiersMap1.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences1() {
		//System.out.println("\nThe number of references in this folder are: " );
		for(Entry<String, Integer> entry : referencesMap1.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printFrequency1() {
		/*for (String word : frequency.keySet()) {
			System.out.println(frequency.get(word) + " : " + frequency.);
		}*/
		System.out.println(frequency1);
	}
	
	
	
	
	
	
	public void printMentions2() {
		//System.out.println("The number of mentions in this folder are: " );
		for(Entry<String, Integer> entry : mentionsMap2.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics2() {
		//System.out.println("\nThe number of topics in this folder are: " );
		for(Entry<String, Integer> entry : topicsMap2.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers2() {
		//System.out.println("\nThe number of identifiers in this folder are: " );
		for(Entry<String, Integer> entry : identifiersMap2.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences2() {
		//System.out.println("\nThe number of references in this folder are: " );
		for(Entry<String, Integer> entry : referencesMap2.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printFrequency2() {
		/*for (String word : frequency.keySet()) {
			System.out.println(frequency.get(word) + " : " + frequency.);
		}*/
		System.out.println(frequency2);
	}
	
	
	
	
	
	
	public void printMentions3() {
		//System.out.println("The number of mentions in this folder are: " );
		for(Entry<String, Integer> entry : mentionsMap3.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printTopics3() {
		//System.out.println("\nThe number of topics in this folder are: " );
		for(Entry<String, Integer> entry : topicsMap3.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printIdentifiers3() {
		//System.out.println("\nThe number of identifiers in this folder are: " );
		for(Entry<String, Integer> entry : identifiersMap3.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printReferences3() {
		//System.out.println("\nThe number of references in this folder are: " );
		for(Entry<String, Integer> entry : referencesMap3.entrySet())
	    {   //print keys and values
	         System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	}
	
	public void printFrequency3() {
		/*for (String word : frequency.keySet()) {
			System.out.println(frequency.get(word) + " : " + frequency.);
		}*/
		System.out.println(frequency3);
	}
	
	
	
	
	
	
	public void printMentionsArray() {
		System.out.println(mentions);
	}
	
	public void getLocation() {
		System.out.println(folderLocation);
	}
	/*
	public String changeFilePath1() {
		String filePath = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test.txt";
		return filePath;
	}*/
	/*
	public File[] changeFilePath1() {
		String location = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test.txt";
		File[] files = new File(location).listFiles();
		return files;
	}
	
	public String changeFilePath2() {
		folderLocation = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test2.txt";
		return folderLocation;
	}
	
	public String changeFilePath3() {
		folderLocation = File.separator + "Users" + File.separator + "Brendan"
				+ File.separator + "eclipse-workspace" + File.separator+ "NotesHW1" + 
				 File.separator + "testFiles" + File.separator + "test3.txt";
		return folderLocation;
	}
	*/
}
