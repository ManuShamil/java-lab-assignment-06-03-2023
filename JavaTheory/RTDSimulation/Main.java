package RTDSimulation;

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
    int[] expectedOutComes;

    static final double CRITICAL_VALUE = 18.307;

    
    RTDSimulation( int numRolls )
    {
        this.numRolls = numRolls;

        this.dice1 = new Dice();
        this.dice2 = new Dice();

        this.tallyArray = new int[ Dice.MAX_VALUE * 2 ];
        this.expectedOutComes = new int[ Dice.MAX_VALUE * 2 ];

        for ( int i=0; i< Dice.MAX_VALUE * 2; i++ )
            this.expectedOutComes[i] = (int) Math.round((double)(calculateOutComeProbability(i+1) / Math.pow(6, 2) * numRolls));


    }

    public void Start()
    {
        this.rollDices();
        this.displayResults();
        this.CalculateChiSquare();
    }

    private void displayResults()
    {
        System.out.println("=========================================================");
        System.out.println("\tx\tO\tE");
        
        for( int i=2; i<this.tallyArray.length+1; i++)
            System.out.println( String.format("\t%s\t%s\t%s", i, this.tallyArray[i-1], this.expectedOutComes[i-1]) );

        System.out.println("=========================================================");
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

    private int calculateOutComeProbability( int sum ) {
        if (sum < 2 || sum > 12) return 0;

        int count = 0;
        for (int i = 1; i <= 6; i++)
            for (int j = 1; j <= 6; j++)
                if (i + j == sum)
                    count++;

        return count;
    }

    private void CalculateChiSquare()
    {
        double chiSquare = 0;
        for ( int i=2; i<this.tallyArray.length+1; i++)
            chiSquare += Math.pow( this.tallyArray[i-1] - this.expectedOutComes[i-1], 2 ) / this.expectedOutComes[ i - 1 ];

        System.out.println( String.format("Chi Square Value: %s", chiSquare ));

        System.out.println( 
            chiSquare > CRITICAL_VALUE ? 
                "Do not reject Alternate Hypothesis: The dices are biased" : 
                "Do not reject Null Hypothesis: The dices are unbiased"
            );

    }
    
}

public class Main {
    public static void main( String[] args )
    {
        int numberOfRolls = 1296;

        RTDSimulation simulation = new RTDSimulation( numberOfRolls );
        simulation.Start();
    }
}