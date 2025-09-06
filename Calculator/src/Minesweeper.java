// FINISH ME
// There are 3 FINISH ME statements where you need to add your name 

// YOU DO NOT NEED TO DO ANYTHING else to this part

// YOU WILL NEED TO FINISH THE BOARD CLASS
// and you will need to look at the interfaces that are used

// FINISH ME
// My name is __________________


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Minesweeper extends JFrame implements BoardConstants, ActionListener,Runnable
{ 

  // thread for the animation
  Thread runThread = null;
  int threadDelay = 250;  // the paintComponent method will be called every 25 milliseconds

  boolean debugMode = true;
  
   
  // ***** declaration of JFrame variables *****

  
  // define a mainPanel for components
  JPanel mainPanel;  

  // ***** declaration of menu variables *****

  // define a menu bar variable to hold JMenus
  JMenuBar  menuBar;
  
  // define some JMenus and their JMenuItems
  // define a JMenu called fileMenu and add menuItems
  JMenu     fileMenu;
  JMenuItem exitMenuItem; 
 
  // define JPanels for a BorderLayout
  JPanel     northPanel;
  JPanel     southPanel;
  JPanel     westPanel;
  JPanel     eastPanel;
  JPanel     centerPanel;

  // define buttons
  MyButton [][] button;    // R or B   
   
  Board        board;   // R or B   
  
  JButton      startButton;
  JButton      bombButton;
  
  JLabel       titleLabel; // for top JPanel (northPanel)
    
  boolean      gameIsPlaying; // is a game in progress
  boolean bombDetected = false;
  boolean falseMarker = false;
  boolean clearingBoard = false;
  
  
  // ***** public void initialize *****

  public void initialize()
  { 
   gameIsPlaying = false;     
       
    // create a mainPanel for components
    mainPanel = new JPanel();    

    // ***** assignments for menu variables *****

    menuBar            = new JMenuBar();
    
    fileMenu           = new JMenu("File");
    exitMenuItem       = new JMenuItem("Exit");
                       
    // add mnemonics to the menu system
    fileMenu.setMnemonic('F');
    exitMenuItem.setMnemonic('x');
    
    // add the menuItem addActionListener(this) calls
    // fileMenu
    exitMenuItem.addActionListener(this);
        
    // add menuItems to the fileMenu
    fileMenu.add(exitMenuItem);
    
    
    // add menus to the menuBar
    menuBar.add(fileMenu);
    
    // attach the JMenuBar to the Window
    setJMenuBar(menuBar);
    
    
    // ***** create JPanels for a BorderLayout *****
    northPanel   = new JPanel();
    southPanel   = new JPanel();
    westPanel    = new JPanel();
    eastPanel    = new JPanel();
    centerPanel  = new JPanel();

    mainPanel.setLayout(new BorderLayout());
    centerPanel.setLayout(new GridLayout(defaultNumberOfRows,defaultNumberOfColumns,10,10));

    northPanel.setBackground(new Color(115,205,255));
    southPanel.setBackground(new Color(115,205,255));
    westPanel.setBackground(new Color(115,205,255));
    eastPanel.setBackground(new Color(115,205,255));
    
    // ***** You need to add buttons, etc. to the 5 panels *****
 
 board = new Board(defaultNumberOfRows,defaultNumberOfColumns);
 
   button = new MyButton[defaultNumberOfRows][defaultNumberOfColumns];
   
   for (int r=0; r<defaultNumberOfRows; r++)
   {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
   button[r][c] = new MyButton("",r,c);
   button[r][c].addActionListener(this); 
   // change the font
   Font font = new Font("Courier New",Font.BOLD,32);
   button[r][c].setFont(font);
   centerPanel.add(button[r][c]);
    }
   }    
    
   
   // FINISH ME
   // add your name (first last)
    titleLabel = new JLabel("Minesweeper by Daniel Yang");
 Font font = new Font("Courier New",Font.BOLD,24);
    titleLabel.setFont(font);
 northPanel.add(titleLabel);
 
 startButton = new JButton("New Game");
 font = new Font("Courier New",Font.BOLD,24);
 startButton.setFont(font);
 startButton.addActionListener(this);
 System.out.println("Start");
 southPanel.add(startButton);
 
 bombButton = new JButton("Bomb");
 font = new Font("Courier New",Font.BOLD,24);
 bombButton.setFont(font);
 bombButton.addActionListener(this);
 System.out.println("Bomb");
 southPanel.add(bombButton);
 
    // ***** add the panels to the mainPanel 5 areas *****
    mainPanel.add(northPanel,BorderLayout.NORTH);
    mainPanel.add(southPanel,BorderLayout.SOUTH);
    mainPanel.add(eastPanel,BorderLayout.EAST);
    mainPanel.add(westPanel,BorderLayout.WEST);
    mainPanel.add(centerPanel,BorderLayout.CENTER);

    // make the mainPanel be the main content area and show it
    setContentPane(mainPanel);
    setVisible(true);  // always show the screen last
  }   // end of public void initialize 

  // ***** default constructor *****

  public Minesweeper( )
  { 
    // initialize variables

    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // FINISH ME
    // add your name (first last)
    setTitle("Minesweeper Version 2017 by Daniel Yang");


    initialize( );

  }

  // ***** ActionListener interface methods *****

  // start of actionPerformed (ActionListener interface)
  public void actionPerformed(ActionEvent e)
  { 
    Object source = e.getSource();
    if (source == exitMenuItem)
    {
      System.exit(0);
    }  // end of if
    else if (source == startButton)
    {
     // clear the board, buttons, etc.
     System.out.println("Start Clicked");
  clearBoard();  
      gameIsPlaying = true;
  westPanel.setBackground(Color.RED);
     eastPanel.setBackground(Color.RED);
    }  // end of if (source == startButton)
    else if (source == bombButton)
    {
     // clear the board, buttons, etc.
     System.out.println("Bomb Detected");
     bombDetected = true;
    } 
    else
    {
     if (!gameIsPlaying)
     {
      JOptionPane.showMessageDialog(this,"You must start a new game!");
      return;
     }  
     // handles a click on a button
    for (int r=0; r<defaultNumberOfRows; r++)
    {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
   
    	if (source == button[r][c])
     {
    	 if (bombDetected == false && board.isBomb(r,c)==false)
         {
          board.setCellPlayedOn(r,c);
          button[r][c].setPlayedOn();
          updateButtonInfo();
          if (board.isWinner())
          {
           gameIsPlaying = false;
           JOptionPane.showMessageDialog(this,"You Win!!!");
          }
         }
         else if (bombDetected == true)
         {
        	 System.out.println("2");
             button[r][c].setPlayedOn();
             button[r][c].setStatus('F');
             System.out.println(button[r][c].getStatus());
             updateButtonInfo();
             button[r][c].setBOOO();
             System.out.println(button[r][c].getStatus());
             button[r][c].setText("F");
             if (board.isWinner() && falseMarker==false)
             {
              gameIsPlaying = false;
              JOptionPane.showMessageDialog(this,"You Win!!!");
             }
             if (board.isBomb(r,c)==false)
             {
            	 falseMarker=true;
            	 System.out.println("3");
             }
             bombDetected = false;
         }
         else
         {
          gameIsPlaying = false;
          updateButtonInfo();
          repaint();
          JOptionPane.showMessageDialog(this,"You Lose!!!");
          
         } 
     }
      // they have clicked on the button
      // make the changes to the button
      // and to the board     
   

      // board.printBoard();
      //int numBombs = board.findNumSurroundingBombs(r,c);
      //System.out.println("numBombs="+numBombs);
     }
    
    }
   
         
    
    }
    // end of else
    
    
  
  }// end of actionPerformed


  public void makeBoard()
  {
    board.makeBoard(5);  // make a new board with 5 random bombs
    for (int r=0; r<defaultNumberOfRows; r++)
    {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
     int numBombs = board.findNumSurroundingBombs(r,c);
     button[r][c].setNumSurroundingBombs(numBombs);
    }
    }
   
  }
  
  
  public void clearBoard()
  {
  // FINISH ME
    // add your name (first last)
   clearingBoard = true;
     titleLabel.setText("Minesweeper by Daniel Yang");
  board.clearBoard();
  
  // we set all the buttons to empty
    for (int r=0; r<defaultNumberOfRows; r++)
    {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
   button[r][c].setText("");
   button[r][c].setOwner("");
    }
    }
    // now fill in new info about the bombs
    makeBoard();
    updateButtonInfo();
    clearingBoard=false;
    board.printBoard();
  northPanel.setBackground(new Color(115,205,255));
     westPanel.setBackground(new Color(115,205,255));
     eastPanel.setBackground(new Color(115,205,255));
     titleLabel.setForeground(Color.BLACK);
  }
  
    
  public void updateButtonInfo()
  {
    for (int r=0; r<defaultNumberOfRows; r++)
    {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
     if (board.isBomb(r,c) && button[r][c].getStatus()!='F')
     {
      if (gameIsPlaying)
     button[r][c].setText("");
    button[r][c].setStatus('B');
    button[r][c].setNumSurroundingBombs(0); 
     }
     else if (board.isBomb(r,c) && button[r][c].getStatus()=='F')
     {
      if (gameIsPlaying)
     button[r][c].setText("F");
     }
     else if (board.isPlayedOn(r,c) && bombDetected == false && button[r][c].getStatus()!='F')
     {
    System.out.println("First");
    button[r][c].setText("P");
		button[r][c].setStatus('P');
    int numBombs = board.findNumSurroundingBombs(r,c);  
	    button[r][c].setNumSurroundingBombs(numBombs); 
     }
     else if (board.isPlayedOn(r,c) && bombDetected == true)
     {

    	 if (button[r][c].getStatus()!='F')
    	 {
    		 System.out.println("Second");   
    		 button[r][c].setText("P");
    		    button[r][c].setStatus('P');
    		    int numBombs = board.findNumSurroundingBombs(r,c);
    		    button[r][c].setNumSurroundingBombs(numBombs);
    	 }
    	 else 
    	 {
    		 System.out.println("Wroks");
    		 button[r][c].setText("F");
    		 button[r][c].setStatus('F');
    	 }
    
     }
     else if (button[r][c].getStatus()!='F')
     {
      button[r][c].setText(" ");
      button[r][c].setStatus(' ');
      int numBombs = board.findNumSurroundingBombs(r,c);
      button[r][c].setNumSurroundingBombs(numBombs);
     }
     else if (button[r][c].getStatus()=='F' && clearingBoard == false)
     {
    	 System.out.println("Third");
    	 button[r][c].setText("F");
     }
     else 
     {
    	 button[r][c].setText(" ");
         button[r][c].setStatus(' ');
         int numBombs = board.findNumSurroundingBombs(r,c);
         button[r][c].setNumSurroundingBombs(numBombs);
     }
   button[r][c].setOwner("");
    }
    }
   
  } 
   
   
  public void updateButtonShowInfo(MyButton button, int row, int col)
  {
  button.setShowRowColInfo(false,"row="+row+", "+"col="+col);
  }
  
  public boolean isIn(int a, int b)
  {
	  if (a >= 0 && a < defaultNumberOfRows)
			if (b >= 0 && b < defaultNumberOfColumns)
				return true;
	   
	  return false;
  }
  
  public void resetRowColInfo()
  {
    for (int r=0; r<defaultNumberOfRows; r++)
    {
    for (int c=0; c<defaultNumberOfColumns; c++)
    {
   button[r][c].setShowRowColInfo(false,"");
   button[r][c].setHighlight(false);
    }
    }   
  }
  
  

  
  // ***** main method *****
  public static void main(String[] arguments)
  {
    Minesweeper minesweeper = new Minesweeper();
  }


// we will flash the screen when they win or lose
public void startStopTheThread(boolean start)
{
    if (start)
    {
   runThread = new Thread(this); // the animation is inactive, so let's animate the move
  
   // start the thread to show the animation
   runThread.start();

 }
    else  // they want to stop the animation
    {
   runThread.interrupt();
   runThread = null;
 }
 
}


// this is the Thread's loop that animates the move from 
// position to position
public void run()
  {
     boolean loop = true;
      try
      {
     if (debugMode)
     {
      System.out.println();
   System.out.println("++++++++++++++++++++++++++++++++");
   System.out.println("+++ start animating ++++++++++++");
   System.out.println();
     }
  
     
     while(loop)
     {    
         setFocusable(true);
      requestFocus();
      
      // we will flash the screen 

   
   centerPanel.repaint();
   
      Thread.currentThread().sleep(threadDelay);        
             
        } // end of while(true)
      }
      catch(Exception e)
      {
       loop = false;
       runThread = null;
      }
      loop = false;
      runThread = null;
      if (debugMode)
       System.out.println("Finished with move");
  }


 public void checkForWinner(int r, int c)
 {
      // check to see if it is a valid move
      
            
      // make the move         
     
    // check for a winner here
       boolean isWinner = false;
       boolean isLoser = false;
    
       // we will need to call methods of the board class
       // in order to see if we win or lose or continue on
       
       if (isWinner)   
    {
         gameIsPlaying = false;
        westPanel.setBackground(new Color(115,205,255));
         eastPanel.setBackground(new Color(115,205,255));
         
         titleLabel.setForeground(Color.GRAY);
         titleLabel.setText("You Win!");
         northPanel.setBackground(Color.BLACK);
     
         return;
    }
    
       if (isLoser)   
    {
         gameIsPlaying = false;
        westPanel.setBackground(new Color(115,205,255));
         eastPanel.setBackground(new Color(115,205,255));
         
         titleLabel.setForeground(Color.GRAY);
         titleLabel.setText("You Lose!");
         northPanel.setBackground(Color.BLACK);
    
         return;
    }
    
 
    centerPanel.repaint();
  
 }  
  
  



// class MyButton
class MyButton extends JButton
{
 String owner = "";
 int row=0;
 int col=0;
 boolean showRowColInfo;
 String  rowColInfo;
 boolean highlight;
 char    status;
 int     numSurroundingBombs;
 
 public MyButton(String s, int row, int col)
 {
  super(s);
  this.row = row;
  this.col = col;
  setText(row+","+col);
  showRowColInfo = false;
  rowColInfo = "";
  highlight = false;
  status = ' ';
  numSurroundingBombs = 0;
 } 

 public char getStatus() {
	// TODO Auto-generated method stub
	return status;
}

public void setBomb()
 {
  status = 'B'; 
 }

 public void setOpen()
 {
  status = ' '; 
 }

 public void setPlayedOn()
 {
  status = 'P'; 
 }
 public void setBOOO()
 {
  status = 'F'; 
 }
 
 public void setStatus(char ch)
 {
  status = ch; 
 }
 
 public void setNumSurroundingBombs(int numBombs)
 {
  numSurroundingBombs = numBombs;
 }
 
 public void setShowRowColInfo(boolean showRowColInfo, String rowColInfo)
 {
  this.showRowColInfo = showRowColInfo;
  this.rowColInfo = rowColInfo;
 }
 
 public void setOwner(String owner) 
 {
  this.owner = owner;
 }
 
 public String getOwner() 
 {
  return owner;
 }

 public void setHighlight(boolean value)
 {
  highlight = value; 
 }
 
    public void paintComponent(Graphics window)
    {  
  super.paintComponent((Graphics2D)window);
  Graphics2D g2 = (Graphics2D) window;
  Font font=null;

  font = new Font("Courier New",Font.BOLD,18);
  setFont(font);
  window.setColor(Color.MAGENTA);
  

  if (status == 'F')
  {
   window.setColor(Color.ORANGE);
   setText("F");
   
  }
  else if (status == 'P')
  {
	  window.setColor(Color.ORANGE);
   setText(""+numSurroundingBombs);
   //window.drawString(""+numSurroundingBombs,5,35); 
  }
   //window.drawString(""+numSurroundingBombs,5,35); 
  else if (status == 'B' && !gameIsPlaying)
  {
   window.setColor(Color.RED);
   setText("B");
   //window.drawString(""+status,5,35);
  }
  else
  {
   setText("");
   // window.drawString(""+status,5,35);
  }

  
     }  

}

} // end of class ConnectFour



