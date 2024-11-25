package Strings;
import java.util.*;

public class WordBreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, memo);
    }

    private static List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixWays = backtrack(s.substring(i), wordSet, memo);
                for (String suffix : suffixWays) {
                    result.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        //tree("abcde");
        String[] wordDict = {"cat","cats","and","sand","dog"};
        System.out.println(wordBreak("catsanddog", Arrays.asList(wordDict)));
    }
}

