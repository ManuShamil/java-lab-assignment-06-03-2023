package SetMatrixZero;

public class Main
{

    public static void setZeroes(int[][] newMatrix, int i, int j ) {
        for( int k=0; k<newMatrix.length; k++)
        {
            newMatrix[i][k] = 0;
            newMatrix[k][j] = 0;
        }
    }

    public static void displayMatrix( int[][] matrix ) {
        for( int i=0; i<matrix.length; i++ )
        {
            for( int j=0; j<matrix.length; j++ )
                System.out.print( matrix[i][j] + " " );
            System.out.print("\n");
        }
    }
    public static void main( String[] args )
    {

        int[][] originalMatrix = new int[][]{ {1,1,1}, {1,0,1}, {1,1,1} };
        int n = originalMatrix.length;

        int[][] newMatrix = new int[n][n];
        //! copy original to new.
        for ( int i=0; i<n; i++)
            for( int j=0; j<n; j++)
                newMatrix[i][j] = originalMatrix[i][j];

        displayMatrix( newMatrix );

        for( int i=0; i<n; i++)
            for ( int j=0; j<n; j++)
                if ( originalMatrix[i][j] == 0 )
                    setZeroes( newMatrix, i, j );

        displayMatrix(newMatrix);
    }
}