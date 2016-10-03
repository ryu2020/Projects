import java.util.Scanner;

public class Simulation {
	
	int car;
	int notdoor;
	int finalguess;
	double countwin = 0;

	
	public static void main(String[] args) {
		Simulation game = new Simulation();
		//game.init();
		int z = game.init2();
		System.out.println(z);
		for (int x = 0; x < z; x++){
			//System.out.println(x);
			if (game.play((int)Math.random() * 3, true)){
				//System.out.println("win");
				game.countwin++;
			}
		}
		System.out.println("switch wins = " + (int)game.countwin + "; win % = " + game.format((game.countwin / z) * 100));
		System.out.println("stay wins = " + (z - (int)game.countwin) + "; win % = " + game.format(((z - game.countwin) / z) * 100));
	}

	double format(double d){
		for (int x = 0; x < 4; x++){
			
		}
	}
	
	void init() {
		System.out.println("monty hall");
		System.out.println("theres a car in one of the doors");
		System.out.println("the doors are 0, 1, and 2");
		System.out.println("which one do you think it is");
	}
	
	int init2(){
		Scanner kb = new Scanner(System.in);
		System.out.println("how many times do you want to play?");
		int y = kb.nextInt();
		kb.close();
		return y;

	}
	
	boolean play(int guess, boolean ifSwitch) {
		//System.out.println("playing game");
		car =  (int)(Math.random() * 3.0);
		//System.out.println(car);
		for(int x = 0; x < 3; x++){
			if (x != car && x != guess){
				notdoor = x;
			}
		}
		//System.out.println(notdoor);
		//System.out.println("boi its not in door " + notdoor);
		//System.out.println("do you want to switch your door (y/n)");
		//String ifSwitch = kb.next();
		if (ifSwitch == true) {
			//System.out.println("boi you switched");
			for (int x = 0; x < 3; x++) {
				if (x != notdoor && x != guess){
					//System.out.println(x);
					finalguess = x;
				}
			}
		}
		if (finalguess == car) {
			return true;
		}
		else {
			return false;
		}
	}
}