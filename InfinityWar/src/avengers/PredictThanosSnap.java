package avengers;



/**
 * Given an adjacency matrix, use a random() function to remove half of the nodes. 
 * Then, write into the output file a boolean (true or false) indicating if 
 * the graph is still connected.
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * PredictThanosSnapInputFile name is passed through the command line as args[0]
 * Read from PredictThanosSnapInputFile with the format:
 *    1. seed (long): a seed for the random number generator
 *    2. p (int): number of people (vertices in the graph)
 *    2. p lines, each with p edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note: the last p lines of the PredictThanosSnapInputFile is an ajacency matrix for
 * an undirected graph. 
 * 
 * The matrix below has two edges 0-1, 0-2 (each edge appear twice in the matrix, 0-1, 1-0, 0-2, 2-0).
 * 
 * 0 1 1 0
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * Delete random vertices from the graph. You can use the following pseudocode.
 * StdRandom.setSeed(seed);
 * for (all vertices, go from vertex 0 to the final vertex) { 
 *     if (StdRandom.uniform() <= 0.5) { 
 *          delete vertex;
 *     }
 * }
 * Answer the following question: is the graph (after deleting random vertices) connected?
 * Output true (connected graph), false (unconnected graph) to the output file.
 * 
 * Note 1: a connected graph is a graph where there is a path between EVERY vertex on the graph.
 * 
 * Note 2: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, isConnected is true if the graph is connected,
 *   false otherwise):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(isConnected);
 * 
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/PredictThanosSnap predictthanossnap.in predictthanossnap.out
*/

public class PredictThanosSnap {
    

    
    private static void dfs(int node, boolean[] visitedArray, int[][] adjacencyMatrix)
    {
       visitedArray[node] = true; 
       for(int i = 0; i < adjacencyMatrix[0].length; i++)
       { 
         if(adjacencyMatrix[node][i] == 1 && (!visitedArray[i]))
         {
            dfs(i, visitedArray , adjacencyMatrix);
         }
       } 
    }
    public static void main (String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java PredictThanosSnap <INput file> <OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

         long seed = StdIn.readLong();
         int vertices = StdIn.readInt(); 
         int adjacencyMatrix[][] = new int[vertices][vertices]; 
         boolean isConnected = true;
         boolean deletedArray[] = new boolean[vertices];  
         boolean visitedArray[] = new boolean[vertices];  

         for(int row = 0; row < adjacencyMatrix.length; row++)
         {for(int col = 0; col < adjacencyMatrix[row].length; col++)
             {
                adjacencyMatrix[row][col] = StdIn.readInt(); 
             }
         }  

         /* StdRandom.setSeed(seed);
         * for (all vertices, go from vertex 0 to the final vertex) { 
         *     if (StdRandom.uniform() <= 0.5) { 
         *          delete vertex;
         *     }
         * }
         */
         StdRandom.setSeed(seed);
         for(int i = 0; i < vertices; i++)
         {if(StdRandom.uniform() <= 0.5)
          {
           for(int index = 0; index < vertices; index++)
           {
             adjacencyMatrix[i][index] = 0;//setting all the edges in the matrix to 0
             adjacencyMatrix[index][i] = 0; 
             deletedArray[i] = true; 
           }
          }
         }        
        
         for(int i = 0; i < deletedArray.length; i++)
         {
            if(deletedArray[i] == false)
            {
                dfs(i, visitedArray , adjacencyMatrix);
                break;  
            }
         }

         for(int i = 0; i < visitedArray.length; i++)
         {
            if(visitedArray[i] == false && deletedArray[i] == false)
            {
                isConnected = false; 
                break;
            }
         }
         StdOut.print(isConnected);
        
  
    }
}
