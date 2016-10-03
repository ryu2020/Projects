import java.util.Scanner;


public class game {
	
	int car;
	int notdoor;
	int finalguess;
	double countwin = 0;

	
	public static void main(String[] args) {
		game game = new game();
		game.init();
		game.play();
		//int z = game.init2();
		//System.out.println(z);
		//for (int x = 0; x < z; x++){
			//System.out.println(x);
			//if (game.play((int)Math.random() * 3, true)){
				//System.out.println("win");
				//game.countwin++;
			//}
		//}
		//System.out.println("switch wins = " + (int)game.countwin + "; win % = " + (game.countwin / z) * 100);
		//System.out.println("stay wins = " + (z - (int)game.countwin) + "; win % = " + ((z - game.countwin) / z) * 100);
	}

	void init() {
		System.out.println("monty hall");
		System.out.println("theres a car in one of the doors");
		System.out.println("the doors are 0, 1, and 2");
		System.out.println("which one do you think it is");
	}
	
	void play() {
		Scanner kb = new Scanner(System.in);
		//System.out.println("playing game");
		int guess = kb.nextInt();
		car =  (int)(Math.random() * 3.0);
		//System.out.println(car);
		for(int x = 0; x < 3; x++){
			if (x != car && x != guess){
				notdoor = x;
			}
		}
		//System.out.println(notdoor);
		System.out.println("it's not in door " + notdoor);
		System.out.println("do you want to switch your door (y/n)");
		String ifSwitch = kb.next();
		if (ifSwitch.charAt(0) == 'y') {
			System.out.println("you switched");
			for (int x = 0; x < 3; x++) {
				if (x != notdoor && x != guess){
					//System.out.println(x);
					finalguess = x;
				}
			}
		}
		else{
			finalguess = guess;
		}
		if (finalguess == car) {
			System.out.println("you won");;
		}
		else {
			System.out.println("you chose door " + finalguess + ", but it was in " + car);
		}
	}
}