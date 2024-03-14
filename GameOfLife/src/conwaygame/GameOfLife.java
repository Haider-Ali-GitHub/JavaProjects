package conwaygame;
import java.lang.module.FindException;
import java.security.AlgorithmConstraints;
import java.time.DayOfWeek;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.
 *  Haider Ali, Ha484, Ha484@scarletmail.rutgers.edu
 */
import java.util.Set;

import javax.lang.model.type.UnionType;
import javax.swing.DefaultDesktopManager;
import javax.swing.GroupLayout.Alignment;
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) 
    {
        

         StdIn.setFile(file);
         int r = StdIn.readInt();
         int c = StdIn.readInt();
         grid = new boolean[r][c];  
         for(int row = 0; row < grid.length; row++ )
            {
             for(int col = 0; col < grid[row].length; col++){ 
                String s = StdIn.readString();

                  Boolean b1 = Boolean.parseBoolean(s);
                    if(b1 == true){
                        grid[row][col] =  ALIVE;
                    }
                    else{
                        grid[row][col] = DEAD;
                    }
                }
            }
    }
      

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {
        /*if(grid[row][col] ==  ALIVE){
        return true;
       }
       else{ 
        return false;
        }*/

        return grid[row][col];
       
        // WRITE YOUR CODE HERE
        // update this line, provided so that code compiles
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive() { 

        // WRITE YOUR CODE HERE
        boolean b = false;
        for(int i = 0; i < grid.length; i++ )
        {
         for(int n = 0; n < grid[i].length; n++){ 
                //if alive then b = true
                if(grid[i][n]== ALIVE){
                    b = true;
                }
            }
        }
        
         return b;
        //return false; // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {
        int numOfAliveNeighbors = 0; 
                /*if( row == 0 ){
                row = grid.length - 1;
                }
                if( col == 0 ){
                    col = grid[row].length - 1;
                }
                if(row + 1 < grid.length && col + 1 < grid[0].length)
                {
                 if(grid[row + 1 ][ col + 1] == ALIVE ){
                    numOfAliveNeighbors += 1; 
                }
                if(grid[row + 1 ][ col]  == ALIVE ){
                    numOfAliveNeighbors += 1; 
                }
                if(grid[row - 1 ][ col]  == ALIVE ){
                    numOfAliveNeighbors += 1; 
                }
                if(grid[row ][ col + 1]  == ALIVE ){
                    numOfAliveNeighbors += 1; 
                }
                if(grid[row ][ col - 1]  == ALIVE ){
                    numOfAliveNeighbors += 1; 
                }
                if (grid[row + 1 ][ col - 1] == ALIVE){
                    numOfAliveNeighbors += 1; 
                }
                if (grid[row - 1 ][ col + 1] == ALIVE){
                    numOfAliveNeighbors += 1; 
                }
                if (grid[row - 1 ][ col - 1] == ALIVE){
                    numOfAliveNeighbors += 1; 
                }
            }*/
            int left=col-1;
            int right=col+1;
            int up=row-1;
            int down=row+1;
            if(left<0)
            {
                left=grid[0].length-1;
            }
            if(right>grid[0].length-1)
            {
                right=0;
            }
            if(up<0)
            {
                up=grid.length-1;
            }
            if(down>grid.length-1)
            {
                down=0;
            }
            if(grid[down ][ right] == ALIVE ){
                numOfAliveNeighbors += 1; 
            }
            if(grid[down ][ col]  == ALIVE ){
                numOfAliveNeighbors += 1; 
            }
            if(grid[up ][ col]  == ALIVE ){
                numOfAliveNeighbors += 1; 
            }
            if(grid[row ][ right]  == ALIVE ){
                numOfAliveNeighbors += 1; 
            }
            if(grid[row ][ left]  == ALIVE ){
                numOfAliveNeighbors += 1; 
            }
            if (grid[down ][ left] == ALIVE){
                numOfAliveNeighbors += 1; 
            }
            if (grid[up ][ right] == ALIVE){
                numOfAliveNeighbors += 1; 
            }
            if (grid[up][ left] == ALIVE){
                numOfAliveNeighbors += 1; 
            }
            return numOfAliveNeighbors;
      
     
       // return 0; // update this line, provided so that code compiles
    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {

        boolean[][] newGrid;
        newGrid = new boolean[grid.length][grid[0].length];
       for(int i = 0; i < grid.length; i ++){
         for(int n = 0; n < grid[i].length; n++){
            int numOfAliveNeighbors = numOfAliveNeighbors(i, n);
            if(grid[i][n])
            {
                if(numOfAliveNeighbors==2 || numOfAliveNeighbors==3)
                {
                    newGrid[i][n]=ALIVE;
                }
                else
                {
                    newGrid[i][n]=DEAD;
                }
            }
            else
            {
                if(numOfAliveNeighbors==3)
                {
                    newGrid[i][n]=ALIVE;
                }   
            }
        }
       }
         return newGrid;

                


  
       // return new boolean[1][1];// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        grid = computeNewGrid(); 

    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        for(int i = 0; i < n; i++){
        
           grid = computeNewGrid();
            
        }

    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {
        
        
        int numOfCommunities = 0; 
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(grid.length , grid[0].length);
        for(int i = 0; i < grid.length; i ++){
            for(int n = 0; n < grid[0].length; n++){


                if(grid[i][n] == ALIVE) {
                  /*  if( numOfAliveNeighbors(i, n) == 0 ){

                        numOfCommunities++; 

                    }
                     */
                    if( numOfAliveNeighbors(i, n) >= 1){
                        
                        int row = i;
                        int col = n;
                        int left= col-1;
                        int right=col +1;
                        int up= row - 1;
                        int down=row + 1;

                       
                      
                        if(left<0)
                        {
                            left=grid[0].length-1;
                        }
                        if(right>grid[0].length-1)
                        {
                            right=0;
                        }
                        if( up <0)
                        {
                            up=grid.length-1;
                        }
                        if(down>grid.length-1)
                        {
                            down=0;
                        }
                        
                        if(grid[down ][ right] == ALIVE ){
                            wqu.union(row, col , down , right);
                        }
                        if(grid[down ][ col]  == ALIVE ){
                            wqu.union(row, col , down , col);
                        }
                        if(grid[up ][ col]  == ALIVE ){
                            wqu.union(row, col , up , col);
                        }
                        if(grid[row ][ right]  == ALIVE ){
                            wqu.union(row, col , row , right);
                        }
                        if(grid[row ][ left]  == ALIVE ){
                            wqu.union(row, col , row , left);
                        }
                        if (grid[down ][ left] == ALIVE){
                            wqu.union(row, col , down , left); 
                        }
                        if (grid[up ][ right] == ALIVE){
                            wqu.union(row, col , up , right);
                        }
                        if (grid[up][ left] == ALIVE){
                            wqu.union(row, col , up , left);
                        }
                            
                    }
                    
                  
                    /*if(arraylist.contains(grid[i][n])){
                        continue;
                    }
                    else{
                        arraylist.add(grid[i][n]);
                    }
                    numOfCommunities++;  
                    */

                }
            }
        }
            ArrayList<Integer> parentArrayList = new ArrayList<>(); 
                  
            for(int j = 0; j < grid.length; j ++){
                for(int k = 0; k < grid[0].length; k++){  
                    if( grid[j][k] == ALIVE){
                        int f = wqu.find(j,k);
                        if(!parentArrayList.contains(f))
                        {
                            parentArrayList.add(f);
                            numOfCommunities++; 
                        }
                       
                        /*if(parentArrayList.contains(f)){
                            continue;
                        }
                        else{
                            parentArrayList.add(f);
                            numOfCommunities++; 
                        }*/
                         
                 }

              } 
           }
         
            return numOfCommunities;
        }   
        
        // WRITE YOUR CODE HERE
        //return numOfCommunities; 
        //return 0; // update this line, provided so that code compiles
    }
