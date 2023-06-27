package leetcode.google.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akarande
 **/
public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String email[] = emails[i].split("@");
            // Remove all '+' signs
            String noPlusStr = email[0].split("\\+")[0];
            // Remove all '.' signs
            String refinedEmail = removeSymbol(noPlusStr, '.');
            set.add(refinedEmail + '@' + email[1]);
        }
        for (String t : set) System.out.println("Email:" + t);
        return set.size();
    }

    String removeSymbol(String s, char symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol) continue;
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String emails[] = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        UniqueEmails uniqueEmails = new UniqueEmails();
        int result = uniqueEmails.numUniqueEmails(emails);
        System.out.println("result = " + result);

    }
}
