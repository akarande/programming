package leetcode.amazon;

import java.util.Comparator;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String a[] = version1.split("\\.");
        String b[] = version2.split("\\.");
        if (a.length == 0) a = new String[] {version1};
        if (b.length == 0) b = new String[] {version2};
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int v1 = Integer.valueOf(a[i++]);
            int v2 = Integer.valueOf(b[j++]);
            if (v1 < v2) return -1;
            else if (v1 > v2) return 1;
        }
        while (i < a.length) if (Integer.valueOf(a[i++]) > 0) return 1;
        while(j < b.length) if (Integer.valueOf(b[j++]) > 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        CompareVersions compareVersions = new CompareVersions();
        String s1 = "1.0.1", s2 = "1";
        int ans = compareVersions.compareVersion(s1, s2);
        System.out.println("ans = " + ans);
    }
}
