public class ReverseString {
	
	public static void main (String[] args) {
		String afterReversed = reverse("   the   sky is blue ");
		System.out.print(afterReversed);
	}
	
	public static String reverse (String s) {
		if (s.length() <= 1 || s == null) return s;
		String[] sNoSpace = s.split(" +");
		int sLength = sNoSpace.length;
		for (int i = 0; i < sLength / 2; i++) {
			String hold = sNoSpace[i];
			sNoSpace[i] = sNoSpace[sLength - 1 - i];
			sNoSpace[sLength - 1 - i] = hold;
		}
		String answer = "";
		for (String ss : sNoSpace) {
			//answer += ss +  " ";
			System.out.print(ss + " ");
		}
		return answer;
	}
}
