import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] A, int L, int R)
    {
        List<Integer> auxiliary = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
        {
            auxiliary.add(A[i]);
        }
        int[] subArrayLeft = new int[A.length];
        int leftCounter = 0;
        for(int i = 0; i < auxiliary.size(); i++)
        {
                if (auxiliary.get(i) < L) {
                    subArrayLeft[leftCounter] = auxiliary.get(i);
                    leftCounter++;
                    auxiliary.remove(i);
                    i--;
                    if(auxiliary.size() == 0)
                    {
                        break;
                    }
                }
        }
        int repeatedCounterLeft = 0;
        for(int i = 0; i < subArrayLeft.length-1; i++)
        {
            if((subArrayLeft[i] == 0) && (subArrayLeft[i] != subArrayLeft[i+1]))
            {
                repeatedCounterLeft++;
            }
            else if(subArrayLeft[i] == subArrayLeft[i+1])
            {
                auxiliary.add(subArrayLeft[i]);
                repeatedCounterLeft++;
            }
        }
        if(subArrayLeft[subArrayLeft.length-1] == 0)
        {
            repeatedCounterLeft++;
        }
        int leftAnswer = subArrayLeft.length - repeatedCounterLeft;
        int rightAnswer = 0;
        int[] subArrayRight = new int[A.length];
        int rightCounter = 0;
        if(auxiliary.size() != 0) {
            for (int i = 0; i < auxiliary.size(); i++) {
                if (auxiliary.get(i) > R) {
                    subArrayRight[rightCounter] = auxiliary.get(i);
                    rightCounter++;
                    auxiliary.remove(i);
                    i--;
                    if(auxiliary.size() == 0)
                    {
                        break;
                    }
                }
            }
            int repeatedCounterRight = 0;
            for (int i = 0; i < subArrayRight.length - 1; i++) {
                if ((subArrayRight[i] == subArrayRight[i + 1]) || (subArrayRight[i] == 0)) {
                    repeatedCounterRight++;
                }
            }
            if (subArrayRight[subArrayRight.length - 1] == 0) {
                repeatedCounterRight++;
            }
            rightAnswer = subArrayRight.length - repeatedCounterRight;
        }

        for(int i = 0; i < subArrayLeft.length; i++)
        {
            System.out.println(subArrayLeft[i]);
        }
        System.out.println("--------");
        for(int i = 0; i < subArrayRight.length; i++)
        {
            System.out.println(subArrayRight[i]);
        }
        System.out.println("--------");

        return (leftAnswer + rightAnswer);


    }
}
