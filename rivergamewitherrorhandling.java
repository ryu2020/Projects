import java.util.Scanner;

public class Game {
	
	Scanner kb = new Scanner(System.in);
	boolean c = false;
	boolean g = false;
	boolean w = false;
	boolean h = false;
	
	public static void main(String[] args){
		Game game = new Game();
		game.redraw();
		while(true){
			game.turn();
			game.redraw();
			if (game.checkloss() || game.checkwin()){
				break;
			}
		}
	}
	
	void turn(){
		System.out.println("what do you want to move?");
		String s = kb.next();
		errorHandler(s);
	}
	
	boolean checkloss(){
		
		if((g == c && g != h) || (g == w && g != h)){ 
			System.out.print("you lose");
			return true;
		}
		return false;
	}
	
	boolean checkwin(){
		if(g == c && c == w && w  == h && h == true){
			System.out.println("you win");
			return true;
		}
		return false;
	}
	
	void redraw(){
		System.out.print(" ");
		if(!c)
			System.out.print("c ");
		if(!g)
			System.out.print("g ");
		if(!w)
			System.out.print("w ");
		if(!h)
			System.out.print("h ");
		System.out.print("\n");
		System.out.println("---------");
		if(!h)
			System.out.println("~~~~|__|~");
		else
			System.out.println("~~~~~~~~~");
		System.out.println("~~~~~~~~~");
		if(h)
			System.out.println("~~~~|__|~");
		else
			System.out.println("~~~~~~~~~");
		System.out.println("---------");
		System.out.print(" ");
		if(c)
			System.out.print("c ");
		if(g)
			System.out.print("g ");
		if(w)
			System.out.print("w ");
		if(h)
			System.out.print("h ");
		System.out.print("\n");
	}

void errorHandler(String s){
	switch(s){
	case "h":
		h = !h;
		break;
	case "c":
		if (c == h){
			c = !c;
			h = !h;
		}
		else{
			System.out.println("you can't do that");
			System.out.println("please enter a valid input (c, g, w, or h)");
			this.errorHandler(kb.next());
		}
		break;
	case "g":
		if (g == h){
			g = !g;
			h = !h;
		}
		else{
			System.out.println("you can't do that");
			System.out.println("please enter a valid input (c, g, w, or h)");
			this.errorHandler(kb.next());
		}
		break;
	case "w":
		if (w == h){
			w = !w;
			h = !h;
		}
		else{
			System.out.println("you can't do that");
			System.out.println("please enter a valid input (c, g, w, or h)");
			this.errorHandler(kb.next());
		}
		break;
	default:
		System.out.println("you can't do that");
		System.out.println("please enter a valid input (c, g, w, or h)");
		this.errorHandler(kb.next());
		break;
	}
}
}