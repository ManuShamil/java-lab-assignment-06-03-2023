package TwoThreads;

import java.util.Random;

class Task1 implements Runnable {
    public void run() {
        for( int i=0; i<100; i++ )
            System.out.println("Hello World!");
    }
}

class Task2 implements Runnable {
    public void run() { 

        Random randomGen = new Random();
        int lowerLimit = 110;
        int upperLimit = 250;

        for ( int i=0; i<100; i++ ) {
            int randomNum = randomGen.nextInt( upperLimit - lowerLimit ) + lowerLimit;
            System.out.println( randomNum );
        }
    }
}

public class Main {
    public static void main( String... args ) {
        Thread thread1 = new Thread( new Task1() );
        Thread thread2 = new Thread( new Task2() );

        thread1.start();
        thread2.start();
    }
}