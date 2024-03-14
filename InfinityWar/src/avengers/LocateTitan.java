package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    private static int getSmallest(int[] array , boolean[] vistedArray){
      int temp = Integer.MAX_VALUE;  
      int minIndex = 0; 
      for (int i = 0; i < array.length; i++)   
      { 
         if (vistedArray[i] != true && array[i] < temp)   
              {  
                  temp = array[i];  
                  minIndex = i; 
              }  
      }  
      return minIndex; 
    }
    public static void main (String [] args) {

        
      if ( args.length < 2 ) {
        StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
        return;
    }

    	
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

        int vertices = StdIn.readInt(); 
        double generator[] = new double[vertices]; 
        int adjacencyMatrix[][] = new int[vertices][vertices]; 

        for(int i = 0; i < generator.length; i++) 
        {
            int index = StdIn.readInt();
            generator[index] = StdIn.readDouble(); 
        }

        for( int row = 0; row < adjacencyMatrix.length; row++)
        {for(int col = 0; col < adjacencyMatrix[0].length; col++)
         {
            adjacencyMatrix[row][col] = StdIn.readInt(); 
         }
        }

//  Divide each value in the adjacency matrix (so matrix[I][j]) with the functionality values of
// vertex i and vertex j (meaning functionalities[i] and
// functionalities([j])
        for( int row = 0; row < adjacencyMatrix.length; row++)
        {for(int col = 0; col < adjacencyMatrix[0].length; col++)
         {
            int updatedVal = (int)(((double)adjacencyMatrix[row][col]) / (generator[row] * generator[col]));
            adjacencyMatrix[row][col] = updatedVal;  
         }
        }

      //dijkis algorithm 
      int minCost[] = new int[vertices]; 
      boolean DijkstraSet[] = new boolean[vertices];
      int Infinity = Integer.MAX_VALUE;

    // Set Each MinCost Value to infinity except node 0;
      for(int i = 0; i < minCost.length; i++)
      {
        if(i == 0)
        {
            minCost[i] = 0;
           
        }
        else
        {
            minCost[i] = Infinity; 
        }
      }

      for( int i = 0; i < minCost.length - 1; i++ )
      {
        int currentSource = getSmallest(minCost , DijkstraSet); 
        DijkstraSet[currentSource] = true; 

        for(int nieghbor = 0; nieghbor < minCost.length; nieghbor++ )
        {
          if(adjacencyMatrix[currentSource][nieghbor] > 0)
          {
            if( DijkstraSet[nieghbor] == false && minCost[currentSource] != Infinity 
             && minCost[currentSource] + adjacencyMatrix[currentSource][nieghbor] < minCost[nieghbor])
            {
              minCost[nieghbor] = minCost[currentSource] + adjacencyMatrix[currentSource][nieghbor];
            }
          }
        }      
      }

    /*  TESTER 
      for(int i = 0; i < minCost.length; i++) {
        StdOut.println( i +" "+ minCost[i]);
      }
      
    */

      StdOut.print(minCost[vertices - 1]);

    }
}
