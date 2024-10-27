package dp;

public class LongestPalindromeSubString {
	public static void main(String[] args) {
		String str = "geekeg";
		System.out.println(longestPalindromeSubString(str));
	}

	private static int longestPalindromeSubString(String A) {
		
		int n = A.length();
		int start = 0;
		int maxLength = 1;

		// DP table results as boolean
		boolean[][] M = new boolean[n][n];

		//base condition for length =1
		for (int i = 0; i < n; i++) {
			M[i][i] = true;
		}
		// 	base condition for length =2
		for (int i = 0; i < n - 1; i++) {
			if (A.charAt(i) == A.charAt(i + 1)) {
				M[i][i + 1] = true;
				start = i;
				maxLength = 2;
			} else
				M[i][i + 1] = false;
		}

		// Fill the DP table from lengths 3 onwards
		for (int l = 3; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1; // this is critical
				if (A.charAt(i) == A.charAt(j) && M[i + 1][j - 1]) {
					M[i][j] = true;
					start = i;
					maxLength = l;
				} else
					M[i][j] = false;
			}
		}
		System.out.println(start + " " + (start + maxLength - 1));
		System.out.println(A.substring(start, start + maxLength));

		// Optional: Print the DP table
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
		return maxLength;

	}
}
