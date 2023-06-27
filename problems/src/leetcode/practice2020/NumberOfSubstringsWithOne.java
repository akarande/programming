package leetcode.practice2020;

import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

/**
 * @author akarande
 **/
public class NumberOfSubstringsWithOne {
    public int numSub(String s) {
        char c[] = s.toCharArray();
        int result = 0, count = 0, N = 1000000007;
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '0') {
                result += (((count * (count + 1)) % N) / 2) % N;
                count = 0;
            }
            else if(c[i] == '1') {
                count++;
            }
        }
        if(count > 0) result += (((count * (count + 1)) % N) / 2) % N;
        return result;
    }

    public static void main(String[] args) {
        /*leetcode.practice2020.NumberOfSubstringsWithOne numberOfSubstringsWithOne = new leetcode.practice2020.NumberOfSubstringsWithOne();
        String num = "0110111";
        int result = numberOfSubstringsWithOne.numSub(num);
        System.out.println("result = " + result);*/
        Set<String> cities = new HashSet<>();
        cities.add("Bombay");
        cities.add("Calcutta");
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Hyderabad");
        //String t = String.format("Cities are %s", cities);
        //System.out.println(t);

        //String s = (String) Stream.of(cities).collect(Collectors.joining(",", "('", "')"));
        /*final StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(cities);
        System.out.println(String.format("list = %s", list));
        //String res = list.stream().map(city -> "(\'" + city + "\')").collect(Collectors.joining(","));
        //System.out.println(res);*/
        ZonedDateTime now = ZonedDateTime.now();
        String format = ISO_INSTANT.format(now);
        System.out.println("now.getNano() = " + now.getNano());
        System.out.println("ZDT = " + format);
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdfDate.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("SDF = " + sdfDate.format(new Date()));
        /*String s = "2020-07-27T20:59:08.529051Z";
        long x = 1L;
        long y = -2L;
        System.out.println("x&y = " + (x & y));*/
    }
}
