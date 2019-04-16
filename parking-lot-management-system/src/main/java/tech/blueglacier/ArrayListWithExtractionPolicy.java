package tech.blueglacier;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListWithExtractionPolicy<E> extends ArrayList<E> {

    public synchronized E getSequential() {
        if (!isEmpty()) {
            return remove(0);
        } else {
            return null;
        }
    }


    public synchronized E takeRandom() {
        if (!isEmpty()) {
            Random random = new Random();
            int randomInt = random.ints(0, size()).findFirst().getAsInt();
            return remove(randomInt);
        } else {
            return null;
        }
    }

}
