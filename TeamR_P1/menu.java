import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class menu {
	
	static readFiles newFiles = new readFiles();
	static Reports report = new Reports();
	Search searchWord = new Search();
	static boolean exit;
	
	public static void main(String[] args) throws IOException {
		
		menu menu = new menu();
		menu.runMenu();
	}
	
	public void runMenu() throws IOException {
		welcome();
		while(!exit) {
			printMenu();
			int choice = getInputMenu1();
			performActionMenu1(choice);
		}
	}
	
	private void welcome() {
		System.out.println("------------------------------------");
		System.out.println("        Welcome to the text         ");
		System.out.println("          report program.           ");
		System.out.println("------------------------------------");
	}
	
	private void printMenu() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("1) General Report ");
		System.out.println("2) Individual Report");
		System.out.println("3) Search");
		System.out.println("0) Exit");
	}
	
	public static void menuTwo() throws IOException {
		System.out.println("-----------------------------");
		newFiles.printLength();
		System.out.println("The file names are as follows: \n");
		newFiles.printFileNames();
		System.out.println("\nWhich file would you like to inspect?");
		System.out.println("Or type \"0\" to exit.\n");
		for (int i=0; i <newFiles.getLength(); i++) {
			System.out.println(i + 1);
		}
		int choice = getInputMenu2();
		performActionMenu2(choice);
	}
	
	public void menuThree() throws IOException {
		newFiles.parseWords();
		int count =0;
		Set<String> set = newFiles.getFrequency();
		
		Scanner sc = new Scanner(System.in);
		String searchWord = "";
		
		System.out.println("-----------------------------");
		System.out.println("What word would you like to search?\n");
		searchWord = sc.nextLine();
	
		for (String word : set) {
			
			Pattern pat = Pattern.compile(".*\\b" + searchWord + "\\b.*");
			Matcher mat = pat.matcher(word);
			if(mat.find()) {
				count++;
			}
		}
		System.out.println(searchWord + " was found " + count + " times.");
		}
	
	
	private int getInputMenu1() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while(choice < 0 || choice > 3 ) {
			try {
				System.out.print("\nEnter your choice:");
				choice = Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid selection: Please try again.");
			}
		}
		return choice;
	}
	
	private void performActionMenu1(int choice) throws IOException {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Thank you for using our application");
			break;
		case 1: report.generalReport();
			break;
		case 2: menuTwo();
			break;
		case 3: menuThree();
		default: 
			//System.out.println("An error has occured.");
			
		}
	}
	
	private static int getInputMenu2() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while(choice < 0 || choice > 3 ) {
			try {
				System.out.print("\nEnter your choice:");
				choice = Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid selection: Please try again.");
			}
		}
		return choice;
	}
	
	private static void performActionMenu2(int choice) throws IOException {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Thank you for using our application");
			break;
		case 1: report.individualReport1();
			break;
		case 2: report.individualReport2();
			break;
		case 3: report.individualReport3();
			break;
		default: 
			//System.out.println("An error has occured.");
			
		}
	}
	
}
