package test;

import java.io.*;

import java.util.*;
import java.util.Map.Entry;

public class Test {
	/*
	 * Complete the function below.
	 */
	static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
		int inputLen = s.length();
		int maxocc = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i <= minLength; i++) {
			for (int j = (i + minLength); j <= maxLength && (i + j - 1) <= inputLen; ++j) {
				System.out.println(i + " " + j);
				String curr = s.substring(i, j);
				int currValue = 1;
				if (map.containsKey(curr)) {
					currValue = map.get(curr);
					currValue++;
				} else {
					map.put(curr, currValue);
				}
				maxocc = (currValue > maxocc) ? currValue : maxocc;
			}
		}
		return maxocc;
	}

	public static int solution(String A, String B) {
		// write your code in Java SE Character8
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 105);
		map.put('K', 104);
		map.put('Q', 103);
		map.put('J', 102);
		map.put('T', 101);
		int count = 0;

		for (int i = 0; i < A.length(); i++) {
			int value1 = ((int) A.charAt(i) - 'A') < 0 ? (int) A.charAt(i) - 'A' : map.get(A.charAt(i));
			int value2 = ((int) B.charAt(i) - 'A') < 0 ? (int) B.charAt(i) - 'A' : map.get(B.charAt(i));
			if (value1 > value2) {
				count++;
			}
		}
		return count;
	}

	public static int solution(String S) {
		// write your code in Java SE 8
		int total = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		String[] str = S.split("\\r?\\n");
		Comparator<String> valueComparator = new Comparator<String>() {
			public int compare(String k1, String k2) {
				String time[] = map.get(k1).split(":");
				int secs = Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60
						+ Integer.parseInt(time[2]);
				String time1[] = map.get(k2).split(":");
				int secs1 = Integer.parseInt(time1[0]) * 3600 + Integer.parseInt(time1[1]) * 60
						+ Integer.parseInt(time1[2]);
				if (secs < secs1)
					return 1;
				else
					return 0;
			}
		};
		TreeMap<String, String> sortedMap = new TreeMap<String, String>(valueComparator);
		sortedMap.putAll(map);
		for (String s : str) {
			String[] bill = s.trim().split(",");
			if (map.get(bill[1]) == null) {
				map.put(bill[1], bill[0]);
			} else {
				String value = map.get(bill[1]);
				String time[] = value.split(":");
				String time1[] = bill[0].split(":");
				int hr = Integer.parseInt(time[0]) + Integer.parseInt(time1[0]);
				int mm = Integer.parseInt(time[1]) + Integer.parseInt(time1[1]);
				int ss = Integer.parseInt(time[2]) + Integer.parseInt(time1[2]);

				map.put(bill[1], String.valueOf(hr).concat(":") + String.valueOf(mm).concat(":") + String.valueOf(ss));
			}
		}
		sortedMap.putAll(map);
		sortedMap.pollFirstEntry();
		for (Entry<String, String> entry : sortedMap.entrySet()) {
			String[] time = entry.getValue().split(":");
			if (Integer.parseInt(time[1]) < 5) {
				total += (Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2])) * 3;
			} else {
				total += (Integer.parseInt(time[1]) + 1) * 150;
			}
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = null;
		// if (fileName != null) {
		// bw = new BufferedWriter(new FileWriter(fileName));
		// }
		// else {
		// bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// }
		//
		// int res;
		// String s;
		// try {
		// s = in.nextLine();
		// } catch (Exception e) {
		// s = null;
		// }
		//
		// int minLength;
		// minLength = Integer.parseInt(in.nextLine().trim());
		//
		// int maxLength;
		// maxLength = Integer.parseInt(in.nextLine().trim());
		//
		// int maxUnique;
		// maxUnique = Integer.parseInt(in.nextLine().trim());
		//
		// int res = getMaxOccurrences("qbcde", 2, 4, 26);
		// System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
		// System.out.println(solution("23A84Q","K2Q25J"));
		System.out.println(
				solution("00:01:07,400-234-090\r\n" + "   00:05:01,701-080-080\r\n" + "   00:05:00,400-234-090"));
	}
}

// }
