// class board holds the data for the board
// there is an inner class called Cell
// class board has several methods that are
//     the same name as the Cell method names
//    in which case the board methods should
//     simply call the method of the Cell class

public class Board implements BoardConstants, BoardMethods 
{

 // holds info about what is on the cell - a bomb, played upon, or blank
 // notice that Cell is an inner class (at the bottom)
 Cell [][] board;
 
 
 // here come the constructors 

  // default constructor Board
    public Board() 
    {
     // FINISH ME
     // instantiate (new) the board defaultNumberOfRows x defaultNumberOfColumns and put spaces into each cell
     board = new Cell[defaultNumberOfRows][defaultNumberOfColumns];
      
      
 
  // FINISH ME
     // loop through all of the board elements (nested loops)
     // for each board position do the following:
     //    create a new Cell object for the position
     //       board[r][c] = ?
     
     for (int r = 0; r < board.length; r++)
     {
      for (int c = 0; c < board[r].length;c++)
      {
        board[r][c] = new Cell();
      }
  // FINISH ME
  // clear the board (call the clearBoard() method
  
    }
     clearBoard();
    }
 
  // constructor Board
    public Board(int rows, int cols) 
    {
     // instantiate (new) the board and put spaces into each cell
     // FINISH ME
    board = new Cell[rows][cols];
     for (int x = 0; x < board.length; x++)
     {
      for (int y = 0; y < board[x].length;y++)
      {
        board[x][y] = new Cell();
      }
  // FINISH ME
  // clear the board (call the clearBoard() method
    }
     clearBoard();
     
     
     // FINISH ME
     // loop through all of the board elements (nested loops)
     // for each board position do the following:
     //    create a new Cell object for the position
     //       board[r][c] = ?
     
  
     
     // FINISH ME
     // call the clearBoard method
     
     
    }
    
 // set the value
 // write the method setCellStatus(int row, int col, char value)
 // it is declared in the interface
    public void setCellStatus(int row, int col, char value)
    {
     // FINISH ME
    board[row][col].setStatus(value);
    }
    
    // return the value of the cell
    // write the method getCellValue(int row, int col)
 // it is declared in the interface
     public char getCellStatus(int row, int col)
    {
     // FINISH ME
    	 return board[row][col].getStatus();
    }
     public char getCellValue(int row, int col)
     {
      // FINISH ME
     	 return board[row][col].getStatus();
     }


    public void setCellBomb(int row, int col)
    {
     // FINISH ME
     // call the setBomb method
    	board[row][col].setBomb();
    }

    public void setCellPlayedOn(int row, int col)
    {
     // FINISH ME
     // call the setPlayed method
     board[row][col].setPlayed();
    }
    public void setBOO(int row, int col)
    {
     // FINISH ME
     // call the setPlayed method
     board[row][col].setBOOM();
    }
    
 public boolean isBomb(int row, int col)
 {
  // FINISH ME
  // check to see if the current cell is a bomb
  //    look at the methods in the Cell class
	 if (board[row][col].getStatus() == 'B')
		 return true;
	 return false;
 } 

 public boolean isPlayedOn(int row, int col)
 {
  // FINISH ME
  // check to see if the current cell has been played on
  // return ?
	 if (board[row][col].getStatus() == 'P')
		 return true;
	 return false;
 } 

 public boolean isOpen(int row, int col)
 {
  // FINISH ME
  // check to see if the current cell is open
  // return ? 
	 if (board[row][col].getStatus() == ' ')
		 return true;
	 return false;
 } 

 public int numBombs(int row, int col)
 {
  // FINISH ME
  // return the number of bombs around this cell
  // don't go out of bounds!
	 int number = 0;
	 for (int r = row -1; r < row +2; row++)
	 {
		 for (int c = col-1; c < col +2; c++)
		 {
			 if(isValid(row, col)== false)
				 continue;
			 if(r== row && c == col)
				 continue;
			 if(isBomb(row, col)==true)
				 number++;
		 }
	 }
	 return number;
 } 

 
    public boolean isPositionAvailable(int row, int col)
    {
     // FINISH ME
     // see if the position is available (i.e. empty which is a space)
     // make sure that you are on the board
    if (isValid(row, col))
    	if (board[row][col].getStatus() == ' ')
    		return true;
    return false;
  // return ?
    }
    
  // set all positions on the board to a space char ' '
    public void clearBoard()
    {
     // FINISH ME
     // use nested loops and set each board[r][c] to a space (' ')
     //    you should call the Cell's setOpen
     // also call the Cell's setNumSurroundingBombs(0) 
     // since we have not added the bombs yet
    	for (int r = 0; r < board.length; r++)
    	{
    		for (int c = 0; c < board[r].length; c++)
    		{
    			board[r][c].setOpen();
    			board[r][c].setNumSurroundingBombs(0);
    		}
    	}
    }


    public void printBoard()
    {
     // FINISH ME
     // use nested loops and print out the board to the console
     //    in matrix format
    	for (int r = 0; r < board.length; r++)
    	{
    		for (int c = 0; c < board[r].length; c++)
    		{
    			System.out.print(board[r][c]);
    		}
    		System.out.println();
    	}
    }

    
    public void makeBoard(int numBombs)
    {
     clearBoard();
     
     for (int i=0; i<numBombs; i++)
     {
      // FINISH ME
      // get a random row on the board (use Math.random())
      // and get a random col
      // stay in bounds!!!
      
      // int r = ? // get a random row on the board
      // int c = ? // get a random column on the board
    int r = (int) (Math.random() * board.length);
    int c = (int) (Math.random() * board[0].length);
      board[r][c].setBomb();
     }
     
     fillCellWithNumSurroundingBombs();
      
    }
    
    
    public int findNumSurroundingBombs(int row, int col)   
    {
     // FINISH ME
     // make sure that you stay on the board (isValid may help)
     // in determining if a cell is on the board
     
    int number = 0;
   	 for (int r = row -1; r < row +2; r++)
   	 {
   		 for (int c = col-1; c < col +2; c++)
   		 {
   			 if(isValid(r, c)==false)
   				 continue;
   			 else if(r== row && c == col)
   				 continue;
   			 else if(isBomb(r, c)==true)
   				 number++;
   		 }
   	 }
   	 return number;     
    }


 // DO NOT TOUCH THIS METHOD
 // this method has been finished for you
 public void fillCellWithNumSurroundingBombs()
 {
     for (int r=0; r < board.length; r++)
     {
       for (int c=0; c < board[r].length; c++)
       {
        if (board[r][c].isOpen() || board[r][c].isPlayedOn())
        {
         int numBombs = findNumSurroundingBombs(r,c);        
     board[r][c].setNumSurroundingBombs(numBombs);        
        }
        else
        {
         board[r][c].setNumSurroundingBombs(0);
        }
       }
     }        
 }
 
 
 public boolean isValid(int row, int col)
 {
  // FINISH ME
  // if row, col is on the board then return true 
  // remember row >= 0 and row < board.length and ... and ...
  
	if (row >= 0 && row < board.length)
		if (col >= 0 && col < board[row].length)
			return true;
   
  return false;
 }
 
 

  // check to see if the player is a winner
  // all cells have been clicked on except for the bombs
  // i.e. there are no open positions (isOpen might help you)
  public boolean isWinner()
  {
 // FINISH ME
   // if there is an open cell, return false, else return true
	  for (int r = 0; r < board.length; r++)
  	{
  		for (int c = 0; c < board[r].length; c++)
  		{
  			if (board[r][c].getStatus() == ' ')
  				return false;
  		}
  	}
   return true;
  }
  
     
  
  // this is an inner class  
  // this class has been finished for you
  class Cell
  {
   char status;  // P=Played on, B=Bomb, ' ' open
   int numSurroundingBombs;
   
   public Cell()
   {
    status = ' ';
    numSurroundingBombs = 0;
   }
   
   public boolean isOpen()
   {
    if (status == ' ')
     return true;
    return false;
   }
   
   public boolean isBomb()
   {
    if (status == 'B')
     return true;
    return false;
   }

 public boolean isPlayedOn()
 {
    if (status == 'P')
     return true;
    return false;  
 }   
  
  
   public void setBomb()
   {
    status = 'B';
   }

   public void setPlayed()
   {
    status = 'P';
   }
   public void setBOOM()
   {
	 System.out.println("4");
    status = 'F';
   }

   public void setOpen()
   {
    status = ' ';
   }

   public void setStatus(char status)
   {
    this.status = status;
   }

   public char getStatus()
   {
    return status;
   }


   public void setNumSurroundingBombs(int numSurroundingBombs)
   {
    System.out.println("hi");
	   this.numSurroundingBombs = numSurroundingBombs;
   }

   public int getNumSurroundingBombs()
   {
    return numSurroundingBombs;
   }

  } // end of class Cell

  
  
  
  
} // end of class Board

