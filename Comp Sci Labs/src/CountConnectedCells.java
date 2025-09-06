
//In this lab you are counting how many land cells are around a given cell. First check to see if the given cell's r,c value is actually land that is on the grid. If so, then use recursion to count the land cells connected.
/* 
Example 3x3

LWL
LWL
LWW

If you were asked how many connected cells there were around r=0 c=0, then your answer would be 3 (0x0, 0x1, 0x2). If asked how many were around r=0,c=1, then it would be 0 since it is water not land.
*/

public class CountConnectedCells {
        

    // count the connected cells (above, below, left, right)
    // 0=water, 1=land, 2=been there done that 
    public static int count(int [][] grid, int r, int c)
    { 
    	// ************************************  	    	
    	// ************************************  	    	
    	// ****** check all stopping conditions 
    	//        (the base cases)
    	// ************************************  	    	
    	// ************************************  	    	

		// FINISH ME
		// base case #1
    	// see if we are off the board
    	//if so, what would you return?
    	
    	if (!isValid(grid, r, c))
    		return 0;


		// FINISH ME
		// base case #2
		// see if we have ocean
		// if so, what would you return?
    	
    	if (grid[r][c] == 0)
    		return 0;

		
		// FINISH ME
		// see if we have already been here
		// since it is land and we already counted it,
		//     what would you return?
    	
    	if (grid[r][c] == 2)
    		return 0;

    	

		// FINISH ME
    	// now we know the spot is land that we have not been to yet. Mark this spot as being visited so that we don't recurse from here again
    	
    	grid[r][c] = 2;
    		
    		
		// FINISH ME
    	// now try to go North, East, South, and West
    	// and return the number of connected cells in
    	// each direction (keep adding to your count)
    	int count = 1;
    	
    	count = 1 + count(grid, r, c+1) + count(grid, r, c-1) + count(grid, r+1, c) + count(grid, r-1, c);


    	return count;
    }

    public static boolean isValid(int [][] grid, int r, int c)
    {
		// FINISH ME
    	if (r >= grid.length || r < 0)
    		return false;
    	if (c >= grid[r].length || c < 0)
    		return false;
    	
    	return true;
    }
    
    
    // main method
    public static void main(String[] args) {
        
		// FINISH ME
        // declare a reference variable to tell
        // us where the grid is in RAM memory
        //    this will be a 2 dimensional array of
        //    integer numbers (0, 1, or 2)
        //    call the reference variable grid
        
    	int[][] grid;
    	
		// FINISH ME
        // create our 6x 6 grid (matrix, 2D array)
        // and store its memory address in grid
        
    	grid = new int[6][6];
        
        // fill with all water
        for (int r=0; r<grid.length; r++)
        {
        	for (int c=0; c<grid[r].length; c++)
        	{
        		grid[r][c] = 0; 
        	}
        }
        
        // add your land 
        grid[2][3] = 1;
        grid[2][4] = 1;
        grid[2][5] = 1;
        grid[3][5] = 1;

        
        int numConnectedCells = count(grid, 2, 3);

        
        System.out.println("Number of connected cells = " + numConnectedCells);
        
        
        
    }
}
