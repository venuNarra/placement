package dp;

public class LongestPalindromeSubSequence {
	static int longestPalindromeSubSequence(String A) {
		int n = A.length();
		int M[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			M[i][i] = 1;
		for (int i = 0; i < n - 1; i++)
			M[i][i + 1] = 1 + (A.charAt(i) == A.charAt(i + 1) ? 1 : 0);
		for (int l = 3; l <= n; l++)
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (A.charAt(i) == A.charAt(j))
					M[i][j] = 2 + M[i + 1][j - 1];
				else
					M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);

			}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
		fecthSequence(M, A);
		return M[0][n - 1];
	}

	private static void fecthSequence(int[][] M, String A) {
		int i = 0;
		int n = M[0].length;
		int j = n - 1;
		int index = M[i][j];
		int start = 0;
		char[] result = new char[index + 1];
		result[index--] = '\0';
		while (i < n - 1 && j > 0) {
			if (A.charAt(i) == A.charAt(j)) {
				result[index] = A.charAt(i);
				System.out.println(index + "  " + start);
				if (index != start)
					result[start] = A.charAt(i);
				i++;
				j--;
				start++;
				index--;
			} else if (M[i][j - 1] > M[i + 1][j])
				j--;
			else
				i++;
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String str = "abcedcbaa";
		System.out.println(longestPalindromeSubSequence(str));
	}
}
