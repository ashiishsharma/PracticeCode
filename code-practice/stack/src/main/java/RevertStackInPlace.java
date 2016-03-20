import java.util.*;
import java.util.Stack;

/**
 * Created by batraa on 4/26/2015.
 */
public class RevertStackInPlace {

    public static void main(String args[]) {

        Stack<Integer> st = new Stack();
        st.push(2);
        st.push(4);
        st.push(5);

        RevertStackInPlace obj = new RevertStackInPlace();
        obj.reverseStack(st);

        Iterator iter = st.iterator();
        while( iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private void reverseStack(Stack<Integer> st) {

        if(st.isEmpty()) {
            return;
        }

        int a = st.pop();
        reverseStack(st);
        appendToBottom(st,a);
     }

    private void appendToBottom(Stack<Integer> st, int a) {

        if(st.isEmpty()) {
            st.push(a);
            return;
        } else {
            int o = st.pop();
            appendToBottom(st,a);
            st.push(o);
        }

     }


}

