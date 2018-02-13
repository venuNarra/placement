package Strings;

public class AnagramSearch {

	private static void search(String patt, String txt) {

		int m = patt.length();
		int n = txt.length();
		int MAX = 256;
		int countP[] = new int[MAX];
		int countT[] = new int[MAX];
		for (int i = 0; i < m; i++) {
			countP[txt.charAt(i)]++;
			countT[patt.charAt(i)]++;
		}
		for (int i = m; i < n; i++) {
			if (compare(countP, countT)) {
				System.out.println(i - m);
			}
			countT[txt.charAt(i)]++;
			countT[txt.charAt(i - m)]--;
		}
		if (compare(countP, countT))
			System.out.println(n - m);
	}

	private static boolean compare(int[] countP, int[] countT) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 256; i++) {
			if (countP[i] != countT[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		search(pat, txt);
	}
}
