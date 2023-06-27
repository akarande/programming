package leetcode.google.arraysandstrings;

/**
 * @author akarande
 **/
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (isStrechy(s, words[i])) result++;
        }
        return result;
    }
        boolean isStrechy(String w1, String w2) {
            int i = 0, j = 0;
            while (i < w1.length() && j < w2.length()) {
                if (w1.charAt(i) == w2.charAt(j)) {
                    int len1 = getLength(w1, i + 1);
                    int len2 = getLength(w2, j + 1);
                    if (len1 == len2 || (len1 > len2 && len1 >= 3)) {
                        i = i + len1;
                        j = j + len2;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return i == w1.length() && j == w2.length();
        }

        int getLength(String word, int index) {
            int count = 1;
            while (index < word.length()) {
                if (word.charAt(index) == word.charAt(index - 1)) count++;
                else break;
                index++;
            }
            return count;
        }

    public static void main(String[] args) {
        ExpressiveWords expressiveWords = new ExpressiveWords();
        String s = "abcd";
        String w[] = {"abc"};
        int result = expressiveWords.expressiveWords(s, w);
        System.out.println("result = " + result);
    }
}
