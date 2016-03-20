package codility.frog;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 */
public class FrogJumpTest {


    @Test
    public void frogJumpCount() {
        int jumpCount = jumpCountCalculator(10, 85, 30);
        System.out.println("Jump Count " + jumpCount);
    }

    @Test
    public void frogJumpCount2() {
        int jumpCount = jumpCountCalculator(10, 10, 30);
        System.out.println("Jump Count " + jumpCount);
    }

    private int jumpCountCalculator(int initialPosition, int finalPosition, int jumpSize) {
        int jumpCount = 0;
        int intermediatePosition = initialPosition;
        do {
            if (intermediatePosition < finalPosition) {
                intermediatePosition = intermediatePosition + jumpSize;
                jumpCount++;
            } else {
                break;
            }
        } while (true);
        return jumpCount;
    }

}
