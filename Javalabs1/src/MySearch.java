
import java.util.Arrays;
import java.util.Random;


public class MySearch {

    public static Comparable[] table;
    private int n;
    public static int last=0;


    public Comparable[] intArrayGenerator(int n){
        this.n=n;
        Random randomGenerator = new Random();
        table = new Integer[n];
        int i=0;
        for (Comparable e: table){
            e = randomGenerator.nextInt(50);
            table[i]=e;
            i++;
        }
        Arrays.sort(table);
        last=table.length-1;
        //System.out.println("the array" + table.toString());
        return table;
    }

    public int LinearSearch(Comparable elem){

        for ( int c = 0; c <table.length; c++) {
            if (table[c].compareTo(elem)==0) {
                return c;
            }
        }

        return -1;
    }

    public int BinarySearch(Comparable elem) {
        int start = 0;
        int end = table.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (table[middle].compareTo(elem) == 0) {
                return middle;
            }
            if (table[middle].compareTo(elem) < 0) {
                start = middle + 1;
                continue;
            }
            end = middle - 1;
        }
        return -1;
    }
}




