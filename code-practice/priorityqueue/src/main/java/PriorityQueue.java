import java.io.*;

/**
 * Find largest M items in a stream of N items
 * N is very huge
 * We do not have much space to store all N items
 * If we had space then we could have stored all N items and sorted them
 *
 * We can only use M space to have largest M items
 *
 * You can use array or linkedlist and implement priority queue for below logic which stores N and goes through
 * entire array to delete Max or Min
 *
 * IF we keep unordered array insertion will take O1 time but deletion of Max will take On time
 * IF we keep it as ordered then insertion will take N time but delete max will take O1 time
 * but our goal is logN for insertion, and delete Max or Min
 *
 * Binary Heap is developed using priority queue
 *
 */
public class PriorityQueue {

    public static void main (String[] args) throws IOException {


        int M = Integer.parseInt(args[1]);

        MinPQ<Transaction> pq = new  MinPQ<Transaction>(5);

        //Reading input and storing in list
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
        String line = null;
        while( ( ( line=reader.readLine()) != null) && !(line.trim().length() == 0) ) {

            Transaction item = new Transaction(line);
            pq.insert(item);
            if(pq.size() > M) {
                pq.delMin();
            }

        }
    }
}
