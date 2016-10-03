import java.util.Scanner;
/**
 * ChatBot - a simple chatbot
 * 
 * @author Bert Yu
 * @version 1.0
 */
public class ChatBot {
	
	static String age;
	static String[] dumbQuestions = 
		{
		"Do you like pokémon go?", 
		"What's your favorite sport", 
		"What's your favorite TV show?", 
		"Do you like to play video games?",
		"Do you like music?"
		};
	/**
	 * Main function
	 * 
	 * runs chatbot
	 * 
	 * @param None
	 */
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name.");
		String name = keyboard.nextLine();
		System.out.println("Hi " + name + " how are you?");
		String feeling = keyboard.nextLine();
		System.out.println("Cool to see you are " + feeling + ". I'm doing well myself.");
		System.out.println("How old are you?");
		boolean finished = false;
		while(finished == false) {
			age = keyboard.next();
			try {
				Integer.valueOf(age);
				finished = true;
			}
			catch (NumberFormatException e) {
				System.out.println(age + " is not a number.");
			}
		}
		if (Integer.valueOf(age) > 18) {
			System.out.println("Hey, that's pretty old");
		}
		else {
			System.out.println("Hey, that's pretty young");
		}
		String input = null;
		int x = 0;
		while (input != "bye" && input != "Bye") {
			System.out.println(dumbQuestions[x]);
			input = keyboard.nextLine();
			System.out.println(input + "?" + " That's great.");
			x++;
			if(x > 5) {
				x = 0;
			}
			input = keyboard.next();
		}
		keyboard.close();
	}
	
}
