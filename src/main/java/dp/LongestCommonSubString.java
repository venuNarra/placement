package dp;

public class LongestCommonSubString {
	public static void main(String[] args) {
		String str1 = "loloi";
		String str2 = "philologist";

		System.out.println(longestCommonSubString(str1, str2));
	}

	private static int longestCommonSubString(String A, String B) {

		int max = 0;
		int start = 0;
		int M[][] = new int[A.length() + 1][B.length() + 1];
		for (int i = 0; i <= A.length(); i++)
			M[i][0] = 0;
		for (int j = 0; j <= B.length(); j++)
			M[0][j] = 0;
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					M[i][j] = 1 + M[i - 1][j - 1];
					if (max < M[i][j]) {
						max = M[i][j];
						start = i;
					}
				} else {
					M[i][j] = 0;
				}
			}
		}
		for (int i = 0; i <= A.length(); i++) {
			for (int j = 0; j <= B.length(); j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
		System.out.println(A.substring(start - max, max));
		return max;

	}
}
