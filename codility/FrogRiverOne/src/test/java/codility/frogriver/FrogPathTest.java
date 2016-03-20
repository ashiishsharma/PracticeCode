package codility.frogriver;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ashish Sharma
 */
public class FrogPathTest {

    @Test
    public void frogPath() {

        int A[] = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(5, A));
    }

    public int solution(int X, int[] A) {
        int locationToStart = 1;
        int locationToReach = X;

        Set<Integer> leafPositionSet = new HashSet<Integer>();
        addRequiredLeafPlaces(locationToStart,locationToReach,leafPositionSet);

        int bestTimeToCross = -1;

        for (int i = 0; i < A.length; i++) {
            leafPositionSet.remove(A[i]);

            if(leafPositionSet.isEmpty()){
                bestTimeToCross = i;
                break;
            }
        }
        return bestTimeToCross;
    }

    private void addRequiredLeafPlaces(int locationToStart, int locationToReach, Set leafPositionSet) {
        for (int i = locationToStart; i <= locationToReach ; i++) {
            leafPositionSet.add(i);
        }
    }
}
