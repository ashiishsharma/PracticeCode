import java.util.Random;

/**
 * To shuffle an array of numbers
 Increment i from left to right
 Get a random no. between 0 and i-1 and exchange i with that random no.
 */
public class KnuthShuffle {


    public void shuffle(int[] input) {

        for(int i=1;i<input.length;i++) {
            int random = getRandomNumberBetween(0,i-1);
                exchange(input, i, random);
        }

    }

    private void exchange(int[] input, int i, int random) {
        int temp = input[i];
        input[i] = input[random];
        input[random] = temp;
    }

    public static void main (String args[]) {

        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};

        KnuthShuffle ks = new KnuthShuffle();
        System.out.println("Array Before");
        ks.printArray(arr);
        ks.shuffle(arr);
        System.out.println("Array After");
        ks.printArray(arr);

    }

    private void printArray(int[] arr) {
        for(int x:arr) {
            System.out.println(x);
        }
    }

    public int getRandomNumberBetween(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
