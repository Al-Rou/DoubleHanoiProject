import java.util.Locale;

public class DoubleHanoi {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] A = {1,2,3,6,7,8,11};
        System.out.println(sol.solution(A, 9, 10));
    }
}
