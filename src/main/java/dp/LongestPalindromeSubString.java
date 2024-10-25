package dp;

public class LongestPalindromeSubString {
	public static void main(String[] args) {
		String str = "geekeg";
		System.out.println(longestPalindromeSubString(str));
	}

	private static int longestPalindromeSubString(String A) {
		
		int n = A.length();
		int start = 0;
		int length = 0;
		int[][] M = new int[n][n];
		for (int i = 0; i < n; i++) {
			M[i][i] = 1;
		}
		for (int i = 0; i < n - 1; i++) {
			if (A.charAt(i) == A.charAt(i + 1)) {
				M[i][i + 1] = 1;
				start = i;
				length = 2;
			} else
				M[i][i + 1] = 0;
		}
		for (int l = 3; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (A.charAt(i) == A.charAt(j) && M[i + 1][j - 1] == 1) {
					M[i][j] = 1;
					start = i;
					length = l;
				} else
					M[i][j] = 0;
			}
		}
		System.out.println(start + " " + (start + length - 1));
		System.out.println(A.substring(start, start + length));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
		return length;

	}
}
