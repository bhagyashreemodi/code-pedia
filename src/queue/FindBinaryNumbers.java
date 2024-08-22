package queue;


import java.util.Arrays;
import java.util.Collections;

public class FindBinaryNumbers {

    /*
    Generate Binary Numbers From 1 to n Using a Queue
    if n = 7 , result = 1, 10, 11, 100, 101, 110, 111
     */
    public static String[] findBinaryNumbers(int n) {
        String[] result = new String[n];
        QueueWithLL<String> queue = new QueueWithLL<>();
        queue.enqueue("1");
        for(int i = 0; i < n; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + 0;
            String s2 = result[i] + 1;
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] inputs = { 1, 3, 5, 9, 11 };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tn: " + inputs[i]);
            System.out.println("\n\tBinary numbers " + Arrays.toString(findBinaryNumbers(inputs[i])));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
