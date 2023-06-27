package leetcode.practice2020;

/**
 * @author akarande
 **/
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int a = nums.length - 1, b = -1, c = -1;
        for(int i = nums.length - 1; i - 2 >= 0; i--) {
            if(nums[a] < nums[i]) a = i;
            if(nums[a] > nums[i - 1]) b = i - 1;
            if(nums[b] > nums[i - 2]) c = i - 2;
            if(b != -1 && c != -1) return true;
        }
        return false;
    }

    /*public static void main(String[] args) {
        leetcode.practice2020.IncreasingTripletSubsequence increasingTripletSubsequence = new leetcode.practice2020.IncreasingTripletSubsequence();
        int[] nums = {5,4,3,2,1};
        increasingTripletSubsequence.increasingTriplet(nums);
    }*/

    public static void main(String []args){
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        while(true) {
            int i = s.indexOf('#');
            if(i == -1) break;
            int v = ((s.charAt(i-2) - '0') * 10 + (s.charAt(i - 1) - '0'));
            char curr = (char)(v - 1 +  'a');
            s = s.substring(0, i - 2) + curr + s.substring(i + 1);
            //System.out.println(s);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int v = Integer.valueOf(s.charAt(i)) - '0';
                char c = (char) (v - 1 + 'a');
                sb.append(c);
            }
            else sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
