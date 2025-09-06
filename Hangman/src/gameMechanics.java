import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class gameMechanics extends hangmanRunner {
	
	public void format()
	{
		
		frame.setTitle("Hangman");
		frame.setSize(1000, 1000);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
        
	 
		title = new JLabel();
		title.setText("Hangman");
	    title.setForeground(Color.BLUE);
	    title.setBounds(425, 300, 200, 40);
		title.setFont(new Font("Hangman", Font.PLAIN, 30));
	    title.setVisible(true);
	    title.setFocusable(true);
	    frame.add(title);
	    frame.repaint();
	    
	    winOrLose = new JLabel();
	    winOrLose.setText("");
	    winOrLose.setForeground(Color.BLUE);
	    winOrLose.setBounds(425, 100, 200, 40);
	    winOrLose.setFont(new Font("", Font.PLAIN, 30));
	    winOrLose.setVisible(false);
	    winOrLose.setFocusable(true);
	    frame.add(winOrLose);
	    frame.repaint();
	    
	    guessStatus = new JLabel();
	    guessStatus.setText("");
	    guessStatus.setForeground(Color.BLUE);
	    guessStatus.setBounds(425, 435, 200, 40);
	    guessStatus.setFont(new Font("Hangman", Font.PLAIN, 15));
	    guessStatus.setVisible(true);
	    guessStatus.setFocusable(true);
	    frame.add(guessStatus);
	    frame.repaint();
	    
	    start = new JButton();
	    start.setText("Start Game");
	    start.setForeground(Color.YELLOW);
	    start.setBackground(Color.BLUE);
	    start.setBorderPainted(false);
	    start.setOpaque(true);
	    start.setFont(new Font("Start Game", Font.PLAIN, 30));
	    start.setBounds(380, 340, 240, 40);
	    start.setVisible(true);
	    frame.add(start);
	    start.setFocusable(true);
	    frame.repaint();
	    
	    start2 = new JButton();
	    start2.setText("Start Game");
	    start2.setForeground(Color.YELLOW);
	    start2.setBackground(Color.BLUE);
	    start2.setBorderPainted(false);
	    start2.setOpaque(true);
	    start2.setFont(new Font("Start Game", Font.PLAIN, 30));
	    start2.setBounds(380, 340, 240, 40);
	    start2.setVisible(false);
	    frame.add(start2);
	    start2.setFocusable(true);
	    frame.repaint();
	    
	    options = new JButton();
	    options.setText("Difficulty");
	    options.setForeground(Color.YELLOW);
	    options.setBackground(Color.BLUE);
	    options.setBorderPainted(false);
	    options.setOpaque(true);
	    options.setFont(new Font("Difficulty", Font.PLAIN, 30));
	    options.setBounds(380, 400, 240, 40);
	    options.setVisible(true);
	    frame.add(options);
	    options.setFocusable(true);
	    frame.repaint();
	    
	    options2 = new JButton();
	    options2.setText("Guess Count");
	    options2.setForeground(Color.YELLOW);
	    options2.setBackground(Color.BLUE);
	    options2.setBorderPainted(false);
	    options2.setOpaque(true);
	    options2.setFont(new Font("Guess Count", Font.PLAIN, 30));
	    options2.setBounds(380, 460, 240, 40);
	    options2.setVisible(true);
	    frame.add(options2);
	    options2.setFocusable(true);
	    frame.repaint();
	    
	    easyMode = new JButton();
	    easyMode.setText("Easy");
	    easyMode.setForeground(Color.YELLOW);
	    easyMode.setBackground(Color.BLUE);
	    easyMode.setBorderPainted(false);
	    easyMode.setOpaque(true);
	    easyMode.setFont(new Font("Easy Mode", Font.PLAIN, 30));
	    easyMode.setBounds(380, 250, 240, 40);
	    easyMode.setVisible(false);
	    frame.add(easyMode);
	    easyMode.setFocusable(true);
	    frame.repaint();
	    
	    mediumMode = new JButton();
	    mediumMode.setText("Medium");
	    mediumMode.setForeground(Color.YELLOW);
	    mediumMode.setBackground(Color.BLUE);
	    mediumMode.setBorderPainted(false);
	    mediumMode.setOpaque(true);
	    mediumMode.setFont(new Font("Medium Mode", Font.PLAIN, 30));
	    mediumMode.setBounds(380, 350, 240, 40);
	    mediumMode.setVisible(false);
	    frame.add(mediumMode);
	    mediumMode.setFocusable(true);
	    frame.repaint();
	    
	    hardMode = new JButton();
	    hardMode.setText("Difficult");
	    hardMode.setForeground(Color.YELLOW);
	    hardMode.setBackground(Color.BLUE);
	    hardMode.setBorderPainted(false);
	    hardMode.setOpaque(true);
	    hardMode.setFont(new Font("Hard Mode", Font.PLAIN, 30));
	    hardMode.setBounds(380, 450, 240, 40);
	    hardMode.setVisible(false);
	    frame.add(hardMode);
	    hardMode.setFocusable(true);
	    frame.repaint();
	    
	    
	    fiveMistakes = new JButton();
	    fiveMistakes.setText("5 Lives");
	    fiveMistakes.setForeground(Color.YELLOW);
	    fiveMistakes.setBackground(Color.BLUE);
	    fiveMistakes.setBorderPainted(false);
	    fiveMistakes.setOpaque(true);
	    fiveMistakes.setFont(new Font("5 Lives", Font.PLAIN, 30));
	    fiveMistakes.setBounds(380, 250, 240, 40);
	    fiveMistakes.setVisible(false);
	    frame.add(fiveMistakes);
	    fiveMistakes.setFocusable(true);
	    frame.repaint();
	    
	    nineMistakes = new JButton();
	    nineMistakes.setText("9 Lives");
	    nineMistakes.setForeground(Color.YELLOW);
	    nineMistakes.setBackground(Color.BLUE);
	    nineMistakes.setBorderPainted(false);
	    nineMistakes.setOpaque(true);
	    nineMistakes.setFont(new Font("9 Lives", Font.PLAIN, 30));
	    nineMistakes.setBounds(380, 350, 240, 40);
	    nineMistakes.setVisible(false);
	    frame.add(nineMistakes);
	    nineMistakes.setFocusable(true);
	    frame.repaint();
	    
	    fourteenMistakes = new JButton();
	    fourteenMistakes.setText("16 Lives");
	    fourteenMistakes.setForeground(Color.YELLOW);
	    fourteenMistakes.setBackground(Color.BLUE);
	    fourteenMistakes.setBorderPainted(false);
	    fourteenMistakes.setOpaque(true);
	    fourteenMistakes.setFont(new Font("16 Lives", Font.PLAIN, 30));
	    fourteenMistakes.setBounds(380, 450, 240, 40);
	    fourteenMistakes.setVisible(false);
	    fourteenMistakes.add(hardMode);
	    fourteenMistakes.setFocusable(true);
	    fourteenMistakes.repaint();
	    frame.add(fourteenMistakes);
	    fourteenMistakes.setFocusable(true);
	    frame.repaint();
	    
	    
	    options.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	options.setVisible(false);
	        	options2.setVisible(false);
	        	start.setVisible(false);
	        	title.setVisible(false);
	        	
	        	easyMode.setVisible(true);
	        	mediumMode.setVisible(true);
	        	hardMode.setVisible(true);
	        	
	        }
	    });
	    
	    options2.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	options.setVisible(false);
	        	options2.setVisible(false);
	        	start.setVisible(false);
	        	title.setVisible(false);
	        	
	        	fiveMistakes.setVisible(true);
	        	nineMistakes.setVisible(true);
	        	fourteenMistakes.setVisible(true);
	        	
	        }
	    });
	    
	    human.clear();
	    
	    human.add(head);
	    human.add(headbody);
	    human.add(headbodyarm);
	    human.add(headbody2);
	    human.add(headbody2leg);
	    human.add(headbody2leg2);
	    human.add(headbody2leg2eye);
	    human.add(headbody2leg2eye2);
	    human.add(full);
	    human.add(hat);
	    human.add(hatHand);
	    human.add(hatHand2);
	    human.add(hatHand2Boot);
	    human.add(hatHand2Boot2);
	    
	    fiveMistakes.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	human.clear();
	    	    
	    	    human.add(headbody);
	    	    human.add(headbody2);
	    	    human.add(headbody2leg2);
	    	    human.add(hat);
	    	    human.add(hatHand2Boot2);
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	fiveMistakes.setVisible(false);
	        	nineMistakes.setVisible(false);
	        	fourteenMistakes.setVisible(false);
	        	
	        }
	    });
	    
	    nineMistakes.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	human.clear();
	    	    
	    	    human.add(head);
	    	    human.add(headbody);;
	    	    human.add(headbody2);
	    	    human.add(headbody2leg);
	    	    human.add(headbody2leg2eye2);
	    	    human.add(full);
	    	    human.add(hat);
	    	    human.add(hatHand2);
	    	    human.add(hatHand2Boot2);
	    	    
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	fiveMistakes.setVisible(false);
	        	nineMistakes.setVisible(false);
	        	fourteenMistakes.setVisible(false);
	        	
	        }
	    });
	    
	    
	    fourteenMistakes.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	human.clear();
	    	    
	    	    human.add(head);
	    	    human.add(headbody);
	    	    human.add(headbodyarm);
	    	    human.add(headbody2);
	    	    human.add(headbody2leg);
	    	    human.add(headbody2leg2);
	    	    human.add(headbody2leg2eye);
	    	    human.add(headbody2leg2eye2);
	    	    human.add(full);
	    	    human.add(hat);
	    	    human.add(hatHand);
	    	    human.add(hatHand2);
	    	    human.add(hatHand2Boot);
	    	    human.add(hatHand2Boot2);
	    	    
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	fiveMistakes.setVisible(false);
	        	nineMistakes.setVisible(false);
	        	fourteenMistakes.setVisible(false);
	        	
	        }
	    });
	    
	    
	    
	    easyMode.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	difficulty = 0;
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	easyMode.setVisible(false);
	        	mediumMode.setVisible(false);
	        	hardMode.setVisible(false);
	        	
	        }
	    });
	    
	    
	    
	    mediumMode.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	difficulty = 1;
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	easyMode.setVisible(false);
	        	mediumMode.setVisible(false);
	        	hardMode.setVisible(false);
	        	
	        }
	    });
	    
	    hardMode.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){ 
	        	
	        	difficulty = 2;
	        	
	        	options.setVisible(true);
	        	options2.setVisible(true);
	        	start.setVisible(true);
	        	title.setVisible(true);
	        	
	        	easyMode.setVisible(false);
	        	mediumMode.setVisible(false);
	        	hardMode.setVisible(false);
	        	
	        }
	    });
	    
	    start.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	           
	        	System.out.println("once");
	        	
	        	title.setBounds(380, 375, 250, 60);
	        	title.setFont(new Font("Start Game", Font.PLAIN, 50));
	            start.setVisible(false);
	            options.setVisible(false);
	            options2.setVisible(false);
	            
	            try {
					initiateGame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	          
	            format2();
	            processGuesses();
	    }});
	}
	
	public void initiateGame() throws FileNotFoundException 
	{
		
		
		lettersLeftList.clear();
		lettersGuessedList.clear();
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 26; i++)
		{
			lettersLeftList.add(alphabet.substring(i, i+1));
		}
		
		wordChosen = "";
		wordList.clear();
		
		File dictionary = new File("dictionary.dat");
		Scanner filescan = new Scanner(dictionary);
		
		String keyword = "Easy Words";
		boolean addWord = false;
		
		if (difficulty == 0)
			keyword = "Easy Words";
		else if (difficulty == 01)
			keyword = "Medium Words";
		else if (difficulty == 2)
			keyword = "Difficult Words";
		else
			System.out.println("mistake");
		
		while (filescan.hasNextLine())
		{
			String word = filescan.nextLine();
			if (word.equals(keyword))
			{
				addWord = true;
			}
			if (word.equals("End List"))
			{
				addWord = false;
			}
			
			if (addWord)
			{
				wordList.add(word);
			}
		
		}
		
		wordChosen = wordList.get((int)(Math.random() * (wordList.size())));
		wordChosen = wordChosen.toUpperCase();
		
		int startingPoint = (1000 - 55 * wordChosen.length()) / 2;
		for (int x = 0; x < wordChosen.length(); x++)
		{
			if (wordChosen.substring(x, x+1).equals(" ") == false)
			{
				// System.out.println(wordChosen.substring(x, x+1));
				JLabel letterCorrect = new JLabel();
				letterCorrect.setText(" ");
				letterCorrect.setForeground(Color.BLUE);
				letterCorrect.setBounds(startingPoint + 15 + 55 * x, 660, 35, 35);
				letterCorrect.setFont(new Font(" ", Font.PLAIN, 22));
				letterCorrect.setVisible(true);
				letterCorrect.setFocusable(true);
				
			
				frame.add(letterCorrect);
				frame.repaint();
				
				displayLetters.add(letterCorrect);
				
				letter l = new letter();
				l.setGuessStatus(false);
				l.setLetter(wordChosen.substring(x, x+1));
				letters.add(l);
				
				
				drawRect(startingPoint + 55 * x, 700);
			
			}
			else
			{
				hasSpace = true;
			}
			
		}
		
		
		
	}
	
	public static void drawRect(int a, int b)
	{
		
		JLabel letterLine = new JLabel(blackLine);
		
		letterLine.setBounds(a, b, 45, 5);
		letterLine.setVisible(true);
		frame.add(letterLine);
		frame.repaint();
		
		displayRectangles.add(letterLine);
		
	}
	
	public void format2()
	{
		person = new JLabel(empty);
		person.setBounds(200, 0, 580, 400);
		frame.add(person);
		frame.repaint();
		
		lettersNotUsedTitle = new JLabel();
		lettersNotUsedTitle.setText("Letters Left");
		lettersNotUsedTitle.setForeground(Color.BLUE);
		lettersNotUsedTitle.setBounds(0, 0, 300, 40);
		lettersNotUsedTitle.setFont(new Font("Letters Left", Font.PLAIN, 25));
		lettersNotUsedTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lettersNotUsedTitle.setVisible(true);
		lettersNotUsedTitle.setFocusable(true);
		frame.add(lettersNotUsedTitle);
		frame.repaint();
		
		displayLives = new JLabel();
		displayLives.setText("Lives Left: ");
		displayLives.setForeground(Color.BLUE);
		displayLives.setBounds(650, 300, 300, 40);
		displayLives.setFont(new Font("Lives Left: ", Font.PLAIN, 25));
		displayLives.setHorizontalAlignment(SwingConstants.CENTER);
		displayLives.setVisible(true);
		displayLives.setFocusable(true);
		frame.add(displayLives);
		frame.repaint();
		displayLives.setText("Lives Left: " + human.size());
		
		lettersGuessedTitle = new JLabel();
		lettersGuessedTitle.setText("Letters Guessed");
		lettersGuessedTitle.setForeground(Color.BLUE);
		lettersGuessedTitle.setBounds(680, 0, 300, 40);
		lettersGuessedTitle.setFont(new Font("Letters Guessed", Font.PLAIN, 25));
		lettersGuessedTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lettersGuessedTitle.setVisible(true);
		lettersGuessedTitle.setFocusable(true);
		frame.add(lettersGuessedTitle);
		frame.repaint();
		
		lettersNotUsed = new JLabel();
		lettersNotUsed.setText(" ");
		lettersNotUsed.setForeground(Color.BLUE);
		lettersNotUsed.setBounds(50, 50, 300, 150);
		lettersNotUsed.setFont(new Font(" ", Font.PLAIN, 20));
		lettersNotUsed.setVisible(true);
		lettersNotUsed.setFocusable(true);
		frame.add(lettersNotUsed);
		frame.repaint();
		
		lettersGuessed = new JLabel();
		lettersGuessed.setText(" ");
		lettersGuessed.setForeground(Color.BLUE);
		lettersGuessed.setBounds(680, 40, 300, 60);
		lettersGuessed.setFont(new Font(" ", Font.PLAIN, 15));
		lettersGuessed.setVisible(true);
		lettersGuessed.setFocusable(true);
		frame.add(lettersGuessed);
		frame.repaint();
		
		
		enterLetter = new JTextField("Enter Guess Here!");
		enterLetter.setBounds(400, 500, 200, 50);
		enterLetter.setVisible(true);
		enterLetter.setFocusable(true);
		
		frame.add(enterLetter);
		frame.repaint();
	}
	
	public void processGuesses()
	{
		enterLetter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String removeSpaces = "";
				
				for (int x = 0; x < wordChosen.length(); x++)
				{
					if (wordChosen.substring(x, x+1).equals(" ") == false)
					{
						removeSpaces = removeSpaces + wordChosen.substring(x, x+1);
					}

				}
				
				wordChosen = removeSpaces;
				
				wordChosen = wordChosen.toUpperCase();
				
				String input = enterLetter.getText();
				enterLetter.setText("");
				
				
				if (input.length() == 1)
				{
					input = input.toUpperCase();
					
					boolean guessedCorrectly = false;
					boolean alreadyGuessed = false;
					
					for (int x = 0; x < wordChosen.length(); x++)
					{
						if (input.equals(wordChosen.substring(x, x+1)))
						{
							letters.get(x).setGuessStatus(true);
							
							guessedCorrectly = true;
							correctGuesses++;
						}
					}
					
					for (int x = 0; x < lettersGuessedList.size(); x++)
					{
						if (input.equals(lettersGuessedList.get(x)))
						{
							alreadyGuessed = true;
						}
					}
					
					if (guessedCorrectly==true && alreadyGuessed==false)
					{
						
						guessStatus.setText("You got it!");
						lettersGuessedList.add(input);
						lettersLeftList.remove(input);
						updateLetters();
						
						for (int i = 0; i < letters.size(); i++)
						{
							if (letters.get(i).getGuessStatus()==true)
							{
								displayLetters.get(i).setText(wordChosen.substring(i, i+1));
							}
						}
						
						
						if (correctGuesses == wordChosen.length())
						{
							guessStatus.setText("You Win!");
							gameWon = true;
							
							gameOverSequence();
						
						}
						
						
						
					}
					else if (alreadyGuessed==true)
					{
						guessStatus.setText("You already guessed this number");
						
						alreadyGuessed = false;
					}
					else
					{
						livesCount++;
						
						int lives = human.size() - livesCount;
						
						displayLives.setText("Lives Left: " + lives);
						
						guessStatus.setText("Nope! Try again");
						lettersGuessedList.add(input);
						lettersLeftList.remove(input);
						updateLetters();
						
						if (livesCount==1)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==2)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==3)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==4)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==5)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==6)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==7)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==8)
							person.setIcon(human.get(livesCount-1));
						if (livesCount==human.size()-1)
						{
							person.setIcon(human.get(human.size()-1));
							guessStatus.setText("You Lose!");
							gameWon = false;
							
							for (int x = 0; x < letters.size(); x++)
							{
								if (letters.get(x).getGuessStatus()==false)
								{
									displayLetters.get(x).setForeground(Color.RED);
									displayLetters.get(x).setText(wordChosen.substring(x, x+1));
								}
							}
							
							gameOverSequence();
							
						}
					}
				}
				else
				{
					guessStatus.setText("Enter a valid letter");
				}
			}


		});
	}
	
	public static void updateLetters()
	{
		//System.out.println(lettersLeftList.size());
		String notYetUsed = "<html>";
		for (int x = 0; x < lettersLeftList.size(); x++)
		{
			notYetUsed = notYetUsed + lettersLeftList.get(x) + ", ";
			if ((x+1) % 8 == 0)
				notYetUsed = notYetUsed + "<br/>";
		}
		
		notYetUsed = notYetUsed + "</html>";
		
		lettersNotUsed.setText(notYetUsed);
		
		
		
		String Used = "<html>";
		for (int x = 0; x < lettersGuessedList.size(); x++)
		{
			Used = Used + lettersGuessedList.get(x) + ", ";
			if ((x+1) % 8 == 0)
				Used = Used + "<br/>";
		}
		
		Used = Used + "</html>";
		
		lettersGuessed.setText(Used);
		
		
		
	}
	
	public void gameOverSequence()
	{
		reset = new JButton();
		reset.setText("New Game");
		reset.setForeground(Color.YELLOW);
		reset.setBackground(Color.BLUE);
	    reset.setBorderPainted(false);
	    reset.setOpaque(true);
	    reset.setFont(new Font("New Game", Font.PLAIN, 30));
	    reset.setBounds(380, 580, 240, 40);
	    reset.setVisible(true);
	    frame.add(reset);
	    reset.setFocusable(true);
	    frame.repaint();
	    
	    reset.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	        	
	        	System.out.println("reset");
	        	
	        	reset.setVisible(false);
	        	letters.clear();
	        	
	        	person.setIcon(empty);
	        	
	        	livesCount = 0;
	    		correctGuesses = 0;
	    		
	    		for (int i = 0; i < displayLetters.size(); i++)
	    		{
	    			displayLetters.get(i).setVisible(false);
	    		}
	    		displayLetters.clear();
	    		
	    		for (int j = 0; j < displayRectangles.size(); j++)
	    		{
	    			displayRectangles.get(j).setVisible(false);
	    			frame.remove(displayRectangles.get(j));
	    		}
	    		
	    		displayRectangles.clear();
	    		
	    		enterLetter.setText("Enter Guess Here");
	    		
	    		wordChosen = "";
	    		
	    		    
	     
	        	
	        	title.setText("Hangman");
	    	    title.setBounds(425, 300, 200, 40);
	    		title.setFont(new Font("Hangman", Font.PLAIN, 30));
	    		
	    		start2.setVisible(true);
	    		
	    		if (gameWon)
	    		{
	    			winOrLose.setText("You Win");
	    			winOrLose.setVisible(true);
	    			frame.repaint();
	    		}
	    		else
	    		{
	    			winOrLose.setText("You Lose");
	    			winOrLose.setVisible(true);
	    			frame.repaint();
	    		}
	        	
	    		person.setVisible(false);
	    		enterLetter.setVisible(false);
	    		guessStatus.setVisible(false);
	    		lettersGuessedTitle.setVisible(false);
	    		lettersNotUsedTitle.setVisible(false);
	    		lettersNotUsed.setVisible(false);
	    		lettersGuessed.setVisible(false);
	    		
	    		if (alreadyPressed == false)
	    			execute();
	        }
	    });
	}
	
	public void execute()
	{
		alreadyPressed = true;
		
		
		start2.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	           
	        	person.setVisible(true);
	    		enterLetter.setVisible(true);
	    		guessStatus.setVisible(true);
	    		lettersGuessedTitle.setVisible(true);
	    		lettersNotUsedTitle.setVisible(true);
	    		lettersNotUsed.setVisible(true);
	    		lettersGuessed.setVisible(true);
	        	
	    		title.setVisible(false);
	            start2.setVisible(false);
	            winOrLose.setVisible(false);
	            
	            System.out.println("initiated here");
	            try {
					initiateGame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      
	    }});
	}

}

class letter
{
	private boolean guessedCorrectly;
	private String theLetter;
	
	public void setGuessStatus(boolean b)
	{
		guessedCorrectly = b;
	}
	
	public boolean getGuessStatus()
	{
		return guessedCorrectly;
	}
	
	public void setLetter(String s)
	{
		theLetter = s;
	}
	
	public String getLetter()
	{
		return theLetter;
	}
}
