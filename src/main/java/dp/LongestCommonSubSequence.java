package dp;

public class LongestCommonSubSequence {
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println(lcs(str1, str2));
	}

	// this function returning the length of LCS
	private static int lcs(String A, String B) {

		int[][] M = new int[A.length() + 1][B.length() + 1];


		for (int i = 0; i < A.length(); i++)
			M[i][0] = 0;
		for (int j = 0; j < B.length(); j++)
			M[0][j] = 0;

		// fill the DP table
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					M[i][j] = 1 + M[i - 1][j - 1];
				else
					M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
			}
		}

		// print the DP table
		for (int i = 0; i <= A.length(); i++) {
			for (int j = 0; j <= B.length(); j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
		fetchSequence(M, A, B);
		return M[A.length()][B.length()];
	}

	private static void fetchSequence(int[][] M, String A, String B) {

		int i = A.length();
		int j = B.length();
		int index = M[A.length()][B.length()];
		char[] result = new char[index + 1];
		result[index--] = '\0';
		while (i > 0 && j > 0) {
			if (A.charAt(i-1) == B.charAt(j-1)) {
				result[index--] = A.charAt(i-1);
				i--;
				j--;
			} else if (M[i][j - 1] > M[i - 1][j]) {
				j--;
			} else
				i--;
		}
		System.out.println(result);
	}
}
