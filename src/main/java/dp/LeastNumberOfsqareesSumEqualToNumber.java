package dp;

//least number of squares whose sum is equal to this number
// 13= 4 +9
// 12= 4+4+4
//	16 = 16
//	17= 16+1
public class LeastNumberOfsqareesSumEqualToNumber {
	
	public static int numberOfSquares(int n) {
		int[] minSqarees = new int[n+1];
		for (int i = 1; i <= n; i++)
			minSqarees[i] = i;
		if (n <= 3)
			return minSqarees[n];
		for (int i = 4; i <= n; i++) {
			for (int j = (int) Math.sqrt(i); j > 0; j--) {
				minSqarees[i] = Math.min(minSqarees[i], 1 + minSqarees[i - j * j]);
			}
		}
		for(int i=0;i<=n;i++)
			System.out.print(minSqarees[i]+" ");
		System.out.println();
		return minSqarees[n];
	}

	public static void main(String[] args) {

		System.out.println(numberOfSquares(12));
		System.out.println();
	}
}
