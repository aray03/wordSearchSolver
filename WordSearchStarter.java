import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordSearchStarter {

	public static void main(String[] args) throws FileNotFoundException {
		
		boolean z = true;
		Scanner scan = new Scanner(System.in);
		while(z) {
			WordSearchSolver griddy = new WordSearchSolver(args[0]);
			System.out.print("Enter the word to find (Enter N to quit): ");
			String currentWord = scan.nextLine(); 
			
			if(currentWord.toUpperCase().equals("EXIT") || currentWord.toUpperCase().equals("N")) {
				System.out.println("Exiting Out!");
				break;
			}
			
			griddy.singleWordFinder(currentWord);
			
			System.out.print("\n--Press Enter to Find Another Word--");
			String spam = scan.nextLine(); 
			System.out.println("\n-------------------------------------------");
				
				
		}
			
		scan.close();
	}
}
