package leetcode.microsoft;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reverse.length();) {
            if (i == 0 && reverse.charAt(i) != ' ' || i > 0 && reverse.charAt(i - 1) == ' ' && Character.isLetter(reverse.charAt(i)) || Character.isDigit(reverse.charAt(i))) {
                int k = i;
                StringBuilder word = new StringBuilder();
                while (k < reverse.length()
                        && Character.isLetter(reverse.charAt(k)) || Character.isDigit(reverse.charAt(k))) word.insert(0, reverse.charAt(k++));
                result.append(word);
                i = k;
            } else if (i > 0 && reverse.charAt(i - 1) == ' ' && reverse.charAt(i) == ' ') {
                i++;
            } else {
                result.append(reverse.charAt(i++));
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String s = "EPY2giL";
        ReverseWordsInString wordsInString = new ReverseWordsInString();
        String ans = wordsInString.reverseWords(s);
        System.out.println("ans = " + ans);
    }
}
