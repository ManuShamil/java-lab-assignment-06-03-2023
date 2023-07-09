package FindMax;


public class Main {

    public static <T extends Comparable<T>> T max( T x, T y ) {
        return x.compareTo(y) > 0 ? x : y ;
    }

    public static void main(String[] args) {
        System.out.println( max( 5, 10));
    }
}
