package leetcode.adobe;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String dirs[] = path.split("/");
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].length() == 0) continue;
            if (dirs[i].equals("..")) {
                int k = i - 1;
                while (k >= 0 && (dirs[k].length() == 0 || dirs[k].equals("."))) k--;
                if (k >= 0) dirs[k] = "";
                dirs[i] = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].length() > 0 && !dirs[i].equals(".")) sb.append("/" + dirs[i]);
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public static void main(String[] args) {
        String paths[] = {"/home/", "/home/user/../home2/t1/f2/../../../../text.cvs", "/../", "/a/./b/../../c/"};
        SimplifyPath simplifyPath = new SimplifyPath();
        for (String path : paths) {
            String pathAns = simplifyPath.simplifyPath(path);
            System.out.println("pathAns = " + pathAns);
        }
    }
}
