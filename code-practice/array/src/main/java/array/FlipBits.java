package array;

/**
 *
 You are given an integer array with N elements: d[0], d[1], ... d[N - 1].
 You can perform AT MOST one move on the array: choose any two integers [L, R], and flip all the elements between (and including) the L-th and R-th bits. L and R represent the left-most and right-most index of the bits marking the boundaries of the segment which you have decided to flip.

 What is the maximum number of '1'-bits (indicated by S) which you can obtain in the final bit-string?

 'Flipping' a bit means, that a 0 is transformed to a 1 and a 1 is transformed to a 0 (0->1,1->0).
 Input Format
 An integer N
 Next line contains the N bits, separated by spaces: d[0] d[1] ... d[N - 1]

 Output:
 S

 Constraints:
 1 <= N <= 100000
 d[i] can only be 0 or 1
 0 <= L <= R < n

 Sample Input:
 8
 1 0 0 1 0 0 1 0

 Sample Output:
 6

 Explanation:

 We can get a maximum of 6 ones in the given binary array by performing either of the following operations:
 Flip [1, 5] ==> 1 1 1 0 1 1 1 0
 *
 */
public class FlipBits {


    public static  void main (String[] args) {

        int[] a = {1,0,0,1,0,0,1,0};
        flipBits(a);
        flip(a);
    }


    public static void flipBits(int[] a) {

        int maxDiff = 0;
        int flipStartIndex = 0;
        int flipEndIndex = 0;
        int onesToFlip = 0;
        int totalNumberOfOnes = 0;

        int currentDiff = 0;
        int currentStart = 0;
        int currentOnesToFlip = 0;

        //1 0 0 1 0 0 1 0
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                currentDiff -= 1;
            } else {
                currentDiff += 1;
                currentOnesToFlip++;
                totalNumberOfOnes++;
            }
            if (currentDiff < maxDiff) {
                maxDiff = currentDiff;
                flipStartIndex = currentStart;
                flipEndIndex = i;
                onesToFlip = currentOnesToFlip;
            } else if (currentDiff > 0) {
                currentDiff = 0;
                currentStart = i + 1;
                currentOnesToFlip = 0;
            }
        }
        System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);
    }


    public static void flip(int a[])
    {
        int maxdiff=0;
        int fsindex=0;
        int feindex=0;
        int onestoflip=0;
        int totalones=0;

        int currentdiff=0;
        int currentstart=0;
        int currentonestoflip=0;
        int zerocount=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                currentdiff-=1;
                zerocount++;
            }
            else
            {
                currentdiff+=1;
                currentonestoflip++;
                totalones++;
            }
            if(currentdiff<maxdiff)
            {
                maxdiff=currentdiff;
                fsindex=currentstart;
                feindex=i;
                onestoflip=currentonestoflip;
            }
            else if(currentdiff>0)
            {
                currentdiff=0;
                currentstart=i+1;
                currentonestoflip=0;
            }

        }
        if(zerocount!=0)
            System.out.println(feindex - fsindex + 1 - onestoflip + totalones - onestoflip);
        else
            System.out.println("No zeros to flip, total number of ones"+totalones);
    }
}
