
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            int arrayN = 50;
            MySearch search = new MySearch();
            Comparable[] array = search.intArrayGenerator(arrayN);
            System.out.println("Array:" + Arrays.toString(array));
            System.out.println("Linear Search index: " + search.LinearSearch(7));
            System.out.println("Binary Search index: " + search.BinarySearch(7));

        } catch (Error ex) {
            Logger.getLogger(MaxSubSeq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}