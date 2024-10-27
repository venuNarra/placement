package dp;

import java.util.*;

public class SubsequenceSumK {
    static int subSequenceSumK(int[] a, int k){
        Map<Integer, Integer> map= new HashMap<>();

        for(int num: a){
            Map<Integer, Integer> currentMap= new HashMap<>(map);
            for(int sum: map.keySet()){
                int newSum= sum + num;
                    if (currentMap.containsKey(newSum)) {
                        currentMap.put(newSum, currentMap.get(newSum) + 1);
                    } else {
                        currentMap.put(newSum, 1);
                    }
            }
            if (currentMap.containsKey(num)) {
                currentMap.put(num, currentMap.get(num) + 1);
            } else {
                currentMap.put(num, 1);
            }
            map=currentMap;
        }
        System.out.println(map);
        return map.get(k);
    }



    static void subSequenceSumKPrint(int[] nums, int k){
        Map<Integer, List<List<Integer>>> map= new HashMap<>();
        map.put(0, new ArrayList<>());
        // iterate over the input numbers
        for(int num: nums){
            Map<Integer, List<List<Integer>>> currentMap= new HashMap<>(map);
            // iterate over the map that contains the sum values and its list of the sequences
            for(int sum: map.keySet()) {
                int newSum = sum + num;

                // iterate over the each sequence and add the num element to the list
                if (currentMap.containsKey(newSum)) {
                    List<List<Integer>> subsequences = currentMap.get(sum);
                    // fetch already existing sequences
                    for (List<Integer> seq : subsequences) {
                        List<Integer> newseq = new ArrayList<>(seq);
                        newseq.add(num);
                        currentMap.putIfAbsent(newSum, new ArrayList<>());
                        currentMap.get(newSum).add(newseq);
                    }
                }
            }
            if (currentMap.containsKey(num)) {
                for(List<Integer> seq: currentMap.get(num)) {
                    seq.add(num);
                }
            } else {
                List<Integer> seq= new ArrayList<>();
                seq.add(num);
                currentMap.putIfAbsent(num, new ArrayList<>());
                currentMap.get(num).add(seq);
            }
            map=currentMap;
        }
        System.out.println(map);

        System.out.println(map.get(k));

    }

    public static void main(String[] args) {
        int[] a = {1, -1, 2, 3, 7, -5};
        int sum=2;
        System.out.println(subSequenceSumK(a, sum));
        subSequenceSumKPrint(a,sum);
    }
}
