import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] A, int L, int R)
    {
        int[] auxiliary = new int[A.length+2];
        for(int i = 0; i < A.length; i++)
        {
            auxiliary[i] = A[i];
        }
        auxiliary[A.length] = L;
        auxiliary[A.length+1] = R;
        for(int i = 0; i < auxiliary.length-1; i++)
        {
            for(int j = i+1; j < auxiliary.length; j++)
            {
                if(auxiliary[i] > auxiliary[j])
                {
                    int temp = auxiliary[i];
                    auxiliary[i] = auxiliary[j];
                    auxiliary[j] = temp;
                }
            }
        }
        int indexOfL = 0;
        for(int i = 0; i < auxiliary.length; i++)
        {
            if(auxiliary[i] == L)
            {
                indexOfL = i;
                break;
            }
        }
        int indexOfR = 0;
        for(int i = 0; i < auxiliary.length; i++)
        {
            if(auxiliary[i] == R)
            {
                indexOfR = i;
                break;
            }
        }
        int[] subArrayLeft = new int[indexOfL];
        for(int i = 0; i < indexOfL; i++)
        {
            subArrayLeft[i] = auxiliary[i];
        }
        int repeatedCounterLeft = 0;
        for(int i = 0; i < subArrayLeft.length-1; i++)
        {
            if(subArrayLeft[i] == subArrayLeft[i+1])
            {
                repeatedCounterLeft++;
            }
        }
        int leftAnswer = subArrayLeft.length - repeatedCounterLeft;

        int[] subArrayRight = new int[indexOfR];
        for(int i = indexOfR+1; i < auxiliary.length; i++)
        {
            subArrayRight[i-indexOfR-1] = auxiliary[i];
        }
        int repeatedCounterRight = 0;
        for(int i = 0; i < subArrayRight.length-1; i++)
        {
            if(subArrayRight[i] == subArrayRight[i+1])
            {
                repeatedCounterRight++;
            }
        }
        int rightAnswer = subArrayRight.length - repeatedCounterRight;

        return (leftAnswer+rightAnswer);
    }
}
