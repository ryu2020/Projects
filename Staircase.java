public class Staircase {
	public static void main(String[] args) {	
		staircaseUp(5);
		staircaseDown(5);
	}
	
	static void loop(int y) {
		for (int x = 1; x <= y; x++) {
			System.out.println(x);
		}
	}
	
	static void staircaseUp(int y) {
		for (int x = y; x >= 0; x--){
			for (int z = 0; z < x; z++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	static void staircaseDown(int y) {
		for (int x = 1; x <= y; x++){
			for (int z = 0; z < x; z++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
