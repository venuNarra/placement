package Strings;

public class ReverseWordsInString {

    public static String reverseWordsInString(String input){
        String[] words= input.split(" +");
        StringBuilder sb= new StringBuilder();
        for(int i=words.length-1;i>=0;i--) {
            sb.append(words[i]);
            if(i>0)
                sb.append(" ");
        }
        return sb.toString().trim();

    }
    public static String reverseWordsInStringInplace(String input){
            StringBuilder sb= new StringBuilder();
            int startIndex=0;
            int endIndex=input.length()-1;
            // Step 1: Trim leading/trailing spaces and remove multiple spaces between words
            while(startIndex <= endIndex && input.charAt(startIndex)==' ') startIndex++;
            while(endIndex >= startIndex && input.charAt(endIndex)==' ') endIndex--;

            while(startIndex <= endIndex){
                if(input.charAt(startIndex)!=' ' || sb.length() ==0 || sb.charAt(sb.length()-1)!=' ')
                    sb.append(input.charAt(startIndex));
                startIndex++;
            }
            // Step 2: Reverse the entire string
        reverse(sb,0,sb.length()-1);
            // Step 3: Reverse each word in the reversed string

        int n= sb.length();
        int wordStart=0;
        for(int i=0;i<=n;i++){
                if( i==n || sb.charAt(i)==' '){
                    reverse(sb, wordStart, i-1);
                    wordStart = i+1;
                }
        }
        return sb.toString();
    }


    public static void reverse(StringBuilder sb, int left, int right){
        while(left<right){
                  char temp= sb.charAt(left);
                  sb.setCharAt(left,sb.charAt(right));
                  sb.setCharAt(right,temp);
                  left++;
                  right--;
        }
    }

    public static void main(String[] args) {
        String str="  hello world    Venu ";
        System.out.println(reverseWordsInString(str));

        System.out.println(reverseWordsInStringInplace(str));
    }
}
