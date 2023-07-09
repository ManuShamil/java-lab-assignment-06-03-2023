package Generics;

class BubbleSort<T extends Comparable<T>> {
    
    private T[] array;

    BubbleSort( T[] array ) {
        this.array = array;
    }

    public void sort() {
        int n = this.array.length;
        for ( int i=0; i < n-1; i++ ) {
            for ( int j=0; j<n-i-1; j++ ) {
                if ( this.array[j].compareTo( this.array[j+1] ) > 0 ) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void display() {
        for ( int i=0; i<this.array.length; i++ ) {
            System.out.print( this.array[i] + "\t" );
        }
        System.out.println("");
    }
}

public class Main {
    public static void main(String[] args) {
        BubbleSort<Integer> newIntegerSort = new BubbleSort<Integer>( new Integer[] {43, 54, 54, 13, 65} );
        newIntegerSort.sort();
        newIntegerSort.display();

        BubbleSort<Float> newFloatSort = new BubbleSort<>( new Float[] { 76.4f, 23.4f, 65.0f } );
        newFloatSort.sort();
        newFloatSort.display();




















        
    }
}