import java.util.Scanner;

public class Search {

	readFiles newFiles = new readFiles();
	Scanner sc = new Scanner(System.in);
	
	public void searchForWord(String word){
		String text = sc.nextLine();
		String regex = "(?i).*\\b" + text + "\\b.*";
		if (text == regex) {
			System.out.println("true");
		}
	}
}
