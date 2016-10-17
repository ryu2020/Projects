public class betterString {
	
	int findString(String s, String f, int i){
		for (int x = i; x < s.length() - (f.length() - 1); x++){
			if(s.substring(x, x + f.length()).equals(f)){
				return x;
			}
		}
		return -1;
	}
	
	int countStrings(String s, String f){
		int x = 0;
		int y = 0;
		while(findString(s, f, y) != -1){	
			x++;
			y = findString(s, f, y) + 1;
		}
		return x;
	}
	
	String convertItalics(String s){
		boolean oneUnderscore = false;
		String temp1;
		String temp2;
		if(countStrings(s, "_") % 2 == 0 && findString(s, "__", 0) == -1){
			for (int x = 0; x < s.length(); x++){
				if(s.charAt(x) == '_'){		
					if(oneUnderscore == false){
						temp1 = s.substring(0, x);
						if(x >= s.length() - 1){
							temp2 = "";
						}
						else{
							temp2 = s.substring(x + 1);
						}
						s = temp1 + "<i>" + temp2;
						oneUnderscore = true;
					}
					else{
						temp1 = s.substring(0, x);
						if(x >= s.length() - 1){
							temp2 = "";
						}
						else{
							temp2 = s.substring(x + 1);
						}
						s = temp1 + "</i>" + temp2;
						oneUnderscore = false;
					}			
				}
			}
		}
		return s;
	}	
}
