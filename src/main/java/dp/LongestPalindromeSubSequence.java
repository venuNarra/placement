package dp;

public class LongestPalindromeSubSequence {
	static int longestPalindromeSubSequence(String A) {
		int n = A.length();
		int[][] M = new int[n][n];

		// Base cases for length 1 & 2
		for (int i = 0; i < n; i++)
			M[i][i] = 1;
		for (int i = 0; i < n - 1; i++)
			M[i][i + 1] = 1 + (A.charAt(i) == A.charAt(i + 1) ? 1 : 0);

		// Fill the DP table from the length 3 onwards
		for (int length = 3; length <= n; length++)
			for (int i = 0; i <= n - length; i++) {
				int j = i + length - 1;    // critical
				if (A.charAt(i) == A.charAt(j))
					M[i][j] = 2 + M[i + 1][j - 1];
				else
					M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);

			}
		// Optional: Print the DP table for debugging
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}

		// Fetch and print the longest palindromic subsequence
		fecthSequence(M, A);
		return M[0][n - 1]; // return the 0 to n-1 length string result
	}

	private static void fecthSequence(int[][] M, String A) {
		int i = 0;
		int n = M[0].length;
		int j = n - 1;
		int index = M[i][j];
		int start = 0;
		char[] result = new char[index];
		int end = index -1;
		// Reconstruct the palindromic subsequence
		while (i <= j) {
			if (A.charAt(i) == A.charAt(j)) {
				result[start] = A.charAt(i);
				result[end] = A.charAt(i);
				System.out.println(end + "  " + start);
				i++;
				j--;
				start++;
				end--;
			} else if (M[i][j - 1] > M[i + 1][j])
				j--;
			else
				i++;
		}
		System.out.println(new String(result));
	}

	public static void main(String[] args) {
		String str = "abcedcbaa";// abcedcbaa ; a ; ab; abc ; abce;
		System.out.println(longestPalindromeSubSequence(str));
	}
}
