

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jarkko
 */
public class MaxSubSeq {
    private static final int N = 10;        // number of test points
    private static final int STARTN = 10000;
    private static final int INCN = 5000;
    private static final String OUTPUTFILE = "C:\\Users\\Sachenae\\Desktop\\data1.csv";


    public static void main(String[] args) throws IOException {

        int arrayN;
        PrintWriter pWriter=null;
        arrayN = STARTN;
        try {
            pWriter= new PrintWriter(OUTPUTFILE, "UTF-8");
            pWriter.println("N;Linear Search;Binary Search");

            StringBuilder result = new StringBuilder();
            Stopwatch sw = new Stopwatch();
            System.out.println("Number of CPU core " + Runtime.getRuntime().availableProcessors());
            for (int i = 0; i < N; i++) {
                MySearch search=new MySearch();
                Comparable[] array= search.intArrayGenerator(arrayN);

                Comparable[] elems = search.getTestElems(array);
                MySearch.LinearSearch koe1=new MySearch.LinearSearch();
                MySearch.BinarySearch koe2=new MySearch.BinarySearch();

                search.getAnswers(koe2,elems);
                result.append(arrayN);
                System.out.println("N " + arrayN);
                sw.measure(koe1);
                result.append(";");
                sw.toValue(result);

                sw.measure(koe2);
                result.append(";");
                sw.toValue(result);
                result.append("\n");
                System.out.println( result.toString());
                arrayN += INCN;
            }
            pWriter.println(result.toString().replace(".",","));
            pWriter.flush();
            pWriter.close();

        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(MaxSubSeq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MaxSubSeq.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            pWriter.flush();
            pWriter.close();
        }


    }




}