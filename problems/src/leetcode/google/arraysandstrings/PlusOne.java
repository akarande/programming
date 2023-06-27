package leetcode.google.arraysandstrings;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * @author akarande
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        for (int i = n - 1; i > 0; i--) {
            digits[i - 1] += digits[i] / 10;
            digits[i] %= 10;
        }
        int msb = -1;
        if (digits[0] > 9) {
            msb = digits[0] / 10;
            digits[0] %= 10;
        }
        int res[];
        int k = 0;
        if (msb == -1) res = new int[n];
        else {
            res = new int[n + 1];
            res[k++] = msb;
        }
        for (int i = 0; i < n; i++, k++) {
            res[k] = digits[i];
        }
        return res;
    }

    public static void main(String[] args) {
       /* String pattern = "yyyy-MM-d'T'HH:mm:ss";
        String res = DateTimeFormatter.ISO_DATE_TIME.format(LocalDate.now().atTime(LocalTime.now()));
        System.out.println("res = " + res);*/
        //System.out.println("new Date() = " + new Date());
        getAllTimeZones();
        System.exit(0);
        String pattern = "E MM-d-yyyy HH:mm:ss z";
        TimeZone utc = TimeZone.getTimeZone("UTC");
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern(pattern).withZone(utc.toZoneId());
        String gmt = LocalDateTime.now().format(formattedDate);
        System.out.println("gmt = " + gmt);
        /*System.out.println("formattedDate = " + formattedDate);
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
        System.out.println("DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now(TimeZone.getTimeZone(\"GMT\") = " + DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now(TimeZone.getTimeZone("GMT").toZoneId())));
        LocalDateTime localDT = LocalDateTime.now();
        String currDateTime = DateTimeFormatter.ofPattern(pattern).format(localDT);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parse = LocalDateTime.parse(currDateTime, fmt);
        System.out.println(parse);*/
        System.exit(0);

        PlusOne plusOne = new PlusOne();
        int a[] = {9, 9};
        int[] result = plusOne.plusOne(a);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    static void getAllTimeZones() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String id : zoneIds) {
            ZoneId zoneId = ZoneId.of(id);
            System.out.println("zoneId.getDisplayName(TextStyle.FULL, Locale.US) = " + zoneId.getDisplayName(TextStyle.FULL, Locale.US) + ", " + zoneId.getDisplayName(TextStyle.SHORT, Locale.US));
            /*System.out.println("id          = " + id);
            System.out.println("displayName = " +
                zoneId.getDisplayName(TextStyle.FULL, Locale.US));*/
        }
    }
}
