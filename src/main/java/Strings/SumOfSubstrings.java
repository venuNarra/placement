package Strings;
import java.io.*;


public class SumOfSubstrings {

    /*
     * Complete the 'substrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING n as parameter.
     */

    public static int substrings(String s) {
        // Write your code here
        long sum=0;
        final int MOD = 1_000_000_007;
        for(int i=0; i < s.length(); i++){ // start index
            long currentSum=0;
            for(int j=i; j < s.length(); j++){ // end index
                currentSum = currentSum*10 + s.charAt(j)- '0';
                currentSum%=MOD;
                sum+=currentSum;
                sum%=MOD;

            }
        }
        return (int) sum%MOD;
    }

    public static int substringsDP(String s) {
        // Write your code here
        final int MOD=1_000_000_007;
        // int[] dp=new int[s.length()];
        long prev=(s.charAt(0) - '0');
        long sum=prev;
        for(int i=1;i<s.length();i++){
            prev =((10* prev % MOD + (long)((i+1) * (s.charAt(i)-'0'))%MOD)%MOD);
            sum= (sum + prev)%MOD;
        }

        return (int)sum;
    }



    public static int substringsMaths(String s) {
        // Write your code here
        final int MOD=1_000_000_007;
        long sum=0;
        long mf=1;
        for(int i=s.length()-1;i>=0;i--){
            sum = (sum + (s.charAt(i) - '0') * (i+1) * mf % MOD) % MOD;
            mf = (mf * 10 +1) % MOD;

        }
        return (int)sum;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = bufferedReader.readLine();

        int result = SumOfSubstrings.substringsMaths(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
}
}

