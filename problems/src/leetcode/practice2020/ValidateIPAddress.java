package leetcode.practice2020;

/**
 * @author akarande
 * 468. Validate IP Address
 * https://leetcode.com/problems/validate-ip-address/submissions/
 **/
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0 || IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) return "Neither";
        if(IP.contains(".")) {
            if(isIPv4(IP)) return "IPv4";
        } else {
            if(isIPv6(IP)) return "IPv6";
        }
        return "Neither";
    }

    boolean isIPv4(String s) {
        String[] a = s.split("\\.");
        if(a.length != 4) return false;
        for(String t : a) {
            if(t.length() > 0 && t.length() <= 4 && checkAllDigits(t) && Integer.valueOf(t) >= 0 && Integer.valueOf(t) < 256) continue;
            else return false;
        }
        return true;
    }

    boolean isIPv6(String s) {
        String[] a = s.split(":");
        if(a.length != 8) return false;
        for(String t : a) {
            if(t.length() > 0 && t.length() <= 4 && isIPv6Chars(t)) continue;
            else return false;
        }
        return true;
    }

    boolean checkAllDigits(String s) {
        int i = 0;
        if(s.length() > 1 && s.charAt(0) == '0') return false;
        while(i < s.length()) {
            if(!Character.isDigit(s.charAt(i++))) return false;
        }
        return true;
    }

    boolean isIPv6Chars(String s) {
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(Character.isDigit(curr) || Character.toLowerCase(curr) >= 'a' && Character.toLowerCase(curr) <= 'f') continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateIPAddress ipAddress = new ValidateIPAddress();
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";//"172.16.254.1";
        String ans = ipAddress.validIPAddress(IP);
        System.out.println("ans = " + ans);
    }
}
