package RollTheDice;

import java.util.Random;

class Dice {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 6;

    Random randomGenerator;

    Dice()
    {
        this.randomGenerator = new Random();
    }
    
    public int roll()
    {
        return this.randomGenerator.nextInt( MAX_VALUE ) + MIN_VALUE;
    }
}

class RTDSimulation {

    Dice dice1;
    Dice dice2;

    private int numRolls;
    int[] tallyArray;
    int[] expectedOutComes = new int[] { 0,  36, 72, 108, 144, 180, 216, 180, 144, 108, 72, 36, 0 };

    static final double CRITICAL_VALUE = 18.307;

    
    RTDSimulation( int numRolls )
    {
        this.numRolls = numRolls;

        this.dice1 = new Dice();
        this.dice2 = new Dice();

        this.tallyArray = new int[ Dice.MAX_VALUE * 2 ];
    }

    public void Start()
    {
        this.rollDices();
        this.displayResults();
        this.CalculateChiSquare();
    }

    private void displayResults()
    {
        System.out.println("x\tO\tE");
        
        for( int i=2; i<this.tallyArray.length+1; i++)
            System.out.println( 
                String.format(
                "%s\t%s\t%s", 
                i, 
                this.tallyArray[i-1], 
                this.expectedOutComes[i-1]
                ) 
            );

    }

    private void rollDices()
    {
        for ( int i=0; i<this.numRolls; i++)
        {

            int result = 0;
            result += this.dice1.roll();
            result += this.dice2.roll();

            this.tallyArray[result-1] += 1;
        }
    }

    private void CalculateChiSquare()
    {
        double chiSquare = 0;
        for ( int i=1; i<this.tallyArray.length; i++)
            chiSquare += Math.pow( 
                this.tallyArray[i] - this.expectedOutComes[i], 2 ) / this.expectedOutComes[ i ];

        System.out.println( String.format("Chi Square: %s", chiSquare ));

        if ( chiSquare > CRITICAL_VALUE )
            System.out.println( "Do not reject Alternate Hypothesis: The dices are biased" );
        else    
            System.out.println( "Do not reject Null Hypothesis: The dices are unbiased" );

    }
    
}

public class Main {
    public static void main( String[] args )
    {
        RTDSimulation simulation = new RTDSimulation( 1296 );
        simulation.Start();
    }
}

