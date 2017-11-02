package face;

import java.util.ArrayList;

public class RepeatChars {

	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		String s = "abcdaebijkd";
		ArrayList list = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.println(c + ":"+ s.indexOf(c, i + 1));
			if (s.indexOf(c, i + 1) > -1) {
				Character ch = new Character(c);
				if (!list.contains(ch))
					list.add(ch);
			}
		}
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + ",");
	}
}
