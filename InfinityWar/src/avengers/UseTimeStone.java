package avengers;



/**
 * Given a starting event and an Adjacency Matrix representing a graph of all possible 
 * events once Thanos arrives on Titan, determine the total possible number of timelines 
 * that could occur AND the number of timelines with a total Expected Utility (EU) at 
 * least the threshold value.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * UseTimeStoneInputFile name is passed through the command line as args[0]
 * Read from UseTimeStoneInputFile with the format:
 *    1. t (int): expected utility (EU) threshold
 *    2. v (int): number of events (vertices in the graph)
 *    3. v lines, each with 2 values: (int) event number and (int) EU value
 *    4. v lines, each with v (int) edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note 1: the last v lines of the UseTimeStoneInputFile is an ajacency matrix for a directed
 * graph. 
 * The rows represent the "from" vertex and the columns represent the "to" vertex.
 * 
 * The matrix below has only two edges: (1) from vertex 1 to vertex 3 and, (2) from vertex 2 to vertex 0
 * 0 0 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * UseTimeStoneOutputFile name is passed through the command line as args[1]
 * Assume the starting event is vertex 0 (zero)
 * Compute all the possible timelines, output this number to the output file.
 * Compute all the posssible timelines with Expected Utility higher than the EU threshold,
 * output this number to the output file.
 * 
 * Note 2: output these number the in above order, one per line.
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for total number of timelines
 *     //Call StdOut.print() for number of timelines with EU >= threshold EU 
 * 
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/UseTimeStone usetimestone.in usetimestone.out
 * 
 * 
 */

public class UseTimeStone {


    private static int EUthreshold(int node, int[][] adjacencyMatrix, int[][] euValues , int counter, int totalEU, int secondCounter)
    {
       secondCounter += euValues[node][1]; 
       for(int i = 0; i < adjacencyMatrix[0].length; i++)
       {
         if(    adjacencyMatrix[node][i] == 1 ) 
         {
            counter = EUthreshold(i, adjacencyMatrix, euValues, counter, totalEU , secondCounter);
         }
       }

       if(totalEU <= secondCounter)
            {
                counter++;
            }
       return counter;  
    }
        
    private static int numberofPaths(int node, int[][] adjacencyMatrix, int counter)
    {
       for(int i = 0; i < adjacencyMatrix[0].length; i++)
       {
         if(adjacencyMatrix[node][i] == 1 ) 
         {   
            counter = numberofPaths(i, adjacencyMatrix, counter); 

         }
       }
       counter++;
       return counter;  
    }



    public static void main (String [] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java UseTimeStone <INput file> <OUTput file>");
            return;
        }
         
        StdIn.setFile(args[0]);     
        StdOut.setFile(args[1]);  

        int totalEU = StdIn.readInt(); 
        int nodes = StdIn.readInt(); 

        int euValues[][] = new int[nodes][2];
        int adjacencyMatrix[][] = new int[nodes][nodes]; 
    
       for( int i = 0; i < euValues.length; i++)
        {
            euValues[i][0] = StdIn.readInt(); 
            euValues[i][1] = StdIn.readInt();           
        }

        for(int row = 0;  row < adjacencyMatrix.length; row++)
        {for(int col = 0; col < adjacencyMatrix[0].length; col++)
         {  
            adjacencyMatrix[row][col] = StdIn.readInt(); 
         }
        }
        
        int pathCounter = 0; 
        int secondCounter = 0; 
        int thresholdCounter = 0; 
        StdOut.println(numberofPaths(0, adjacencyMatrix, pathCounter));
        StdOut.print(EUthreshold(0, adjacencyMatrix, euValues, thresholdCounter, totalEU, secondCounter));     
    }
}
