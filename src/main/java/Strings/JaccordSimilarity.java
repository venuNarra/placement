package Strings;
import java.util.*;


public class JaccordSimilarity {
    public static String selectStringsByJaccardSimilarity(List<String> strings, boolean useJaccard) {
        if (!useJaccard) {
            // Call the previous method for most common character logic.
           // return selectStringsWithSmallestProportion(strings);
        }

        int n = strings.size();
        double[] avgJaccardSimilarity = new double[n];

        // Calculate Jaccard similarity between each pair of strings.
        for (int i = 0; i < n; i++) {
            double totalSimilarity = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    totalSimilarity += calculateJaccardSimilarity(strings.get(i), strings.get(j));
                }
            }
            avgJaccardSimilarity[i] = totalSimilarity / (n - 1);
        }

        // Find the minimum average Jaccard similarity.
        double minAverageSimilarity = Double.MAX_VALUE;
        for (double sim : avgJaccardSimilarity) {
            if (sim < minAverageSimilarity) {
                minAverageSimilarity = sim;
            }
        }

        // Collect strings with the lowest average Jaccard similarity.
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (avgJaccardSimilarity[i] == minAverageSimilarity) {
                for (char c : strings.get(i).toCharArray()) {
                    uniqueChars.add(c);
                }
            }
        }

        // Construct the result string from the unique characters.
        StringBuilder result = new StringBuilder();
        for (char c : uniqueChars) {
            result.append(c);
        }

        return result.toString();
    }

    private static double calculateJaccardSimilarity(String s1, String s2) {
        Map<Character, Integer> freqS1 = getCharacterFrequency(s1);
        Map<Character, Integer> freqS2 = getCharacterFrequency(s2);

        int intersectionCount = 0;
        int unionCount = 0;

        Set<Character> allChars = new HashSet<>();
        allChars.addAll(freqS1.keySet());
        allChars.addAll(freqS2.keySet());

        for (char c : allChars) {
            int countInS1 = freqS1.getOrDefault(c, 0);
            int countInS2 = freqS2.getOrDefault(c, 0);

            intersectionCount += Math.min(countInS1, countInS2);
            unionCount += Math.max(countInS1, countInS2);
        }

        return (double) intersectionCount / unionCount;
    }

    private static Map<Character, Integer> getCharacterFrequency(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("baa", "abb", "abc", "bac");
        String result = selectStringsByJaccardSimilarity(input, true);
        System.out.println(result); // Output depends on the Jaccard similarity calculation
    }
}
