public class array2d {
	public static void main(String[] args){
		int i = 1;
		int[][] arr = new int[4][4];
		for (int x = 0; x < 4; x++){
			for(int y = 0; y < 4; y++){
				arr[x][y] =  i;
				i++;
			}
		}
	}
}
