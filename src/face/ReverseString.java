package face;

public class ReverseString {

	public static String reverse(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		} 
		return reverse(s.substring(1)) + s.charAt(0); 
	}
	
	public static void main(String[] args) {
		String s = "abcd";
		
		System.out.println(reverse(s));
		
		StringBuffer sBuffer = new StringBuffer(s);
		System.out.println(sBuffer.reverse());
	}
}
