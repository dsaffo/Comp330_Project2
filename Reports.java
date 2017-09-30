import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;

public class Reports {
	
	readFiles newFiles = new readFiles();
	
public void generalReport() throws IOException {
	
	newFiles.parseWords();
	
		System.out.println("-----------------------------");
		newFiles.printLength();
		System.out.println("The file names are as follows: \n");
		newFiles.printFileNames();
		newFiles.printAllIdentifiers();
		System.out.println("The number of mentions in this folder are: " );
		newFiles.printMentions();
		System.out.println("\nThe number of topics in this folder are: " );
		newFiles.printTopics();
		System.out.println("\nThe number of identifiers in this folder are: " );
		newFiles.printIdentifiers();
		System.out.println("\nThe number of references in this folder are: " );
		newFiles.printReferences();
		System.out.println("-----------------------------");
	}

	public void individualReport1() throws IOException  {
		
		newFiles.parseWords1();
		
		System.out.println("\n-----------------------------\n");
		System.out.println("The number of mentions in this folder are: " );
		newFiles.printMentions1();
		System.out.println("\nThe number of topics in this folder are: " );
		newFiles.printTopics1();
		System.out.println("\nThe number of identifiers in this folder are: " );
		newFiles.printIdentifiers1();
		System.out.println("\nThe number of references in this folder are: " );
		newFiles.printReferences1();
		System.out.println("\nThe total frequency of all the words in this file are as follows: \n");
		newFiles.printFrequency1();
		System.out.println("\n-----------------------------\n");
		
		}
	
public void individualReport2() throws IOException  {
		
		newFiles.parseWords2();
		
		System.out.println("\n-----------------------------\n");
		System.out.println("The number of mentions in this folder are: " );
		newFiles.printMentions2();
		System.out.println("\nThe number of topics in this folder are: " );
		newFiles.printTopics2();
		System.out.println("\nThe number of identifiers in this folder are: " );
		newFiles.printIdentifiers2();
		System.out.println("\nThe number of references in this folder are: " );
		newFiles.printReferences2();
		System.out.println("\nThe total frequency of all the words in this file are as follows: \n");
		newFiles.printFrequency2();
		System.out.println("\n-----------------------------\n");
		
		}
	
public void individualReport3() throws IOException  {
	
	newFiles.parseWords3();
	
	System.out.println("\n-----------------------------\n");
	System.out.println("The number of mentions in this folder are: " );
	newFiles.printMentions3();
	System.out.println("\nThe number of topics in this folder are: " );
	newFiles.printTopics3();
	System.out.println("\nThe number of identifiers in this folder are: " );
	newFiles.printIdentifiers3();
	System.out.println("\nThe number of references in this folder are: " );
	newFiles.printReferences3();
	System.out.println("\nThe total frequency of all the words in this file are as follows: \n");
	newFiles.printFrequency3();
	System.out.println("\n-----------------------------\n");
	
	}
	
	}


