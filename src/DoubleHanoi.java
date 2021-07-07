import java.util.Locale;

public class DoubleHanoi {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] A = {1,5,5};
        System.out.println(sol.solution(A, 2, 4));
    }
}
