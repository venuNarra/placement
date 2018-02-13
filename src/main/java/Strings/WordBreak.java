package Strings;

public class WordBreak {

	private static boolean wordBreak(String str) {

		System.out.println("Word break-------------------" + str);
		if (str.length() == 0)
			return true;
		for (int i = 1; i <= str.length(); i++) {
			if (dictionayContains(str.substring(0, i)) && wordBreak(str.substring(i, str.length())))
				return true;
		}
		return false;
	}

	static void tree(String str) {
		for (int i = 1; i < str.length(); i++) {
			System.out.println(str.substring(i));
			tree(str.substring(i));
		}
	}

	private static boolean dictionayContains(String word) {
		System.out.println(word);
		// TODO Auto-generated method stub
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };
		for (int i = 0; i < dictionary.length; i++)
			if (dictionary[i].equals(word))
				return true;
		return false;
	}

	public static void main(String[] args) {
		tree("abcde");
		//System.out.println(wordBreak("ilikesamsung"));
	}

}
