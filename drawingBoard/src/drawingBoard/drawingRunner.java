package drawingBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class drawingRunner {

		public static JFrame mainframe;
		
		public static ImageIcon boardv1;
		public static Image boardImg;
		public static ImageIcon board;
		
		public static ImageIcon bluerectangle;
		public static Image blueRectImg;
		public static ImageIcon blueRect;
		public static ImageIcon blueRects;
		public static ImageIcon blueRect2;
		
		public static ImageIcon brownrectangle;
		public static Image brownRectImg;
		public static ImageIcon brownRect;
		public static ImageIcon brownRects;
		public static ImageIcon brownRect2;
		
		public static ImageIcon redrectangle;
		public static Image redRectImg;
		public static ImageIcon redRect;
		public static ImageIcon redRects;
		public static ImageIcon redRect2;
		
		public static ImageIcon greenrectangle;
		public static Image greenRectImg;
		public static ImageIcon greenRect;
		public static ImageIcon greenRects;
		public static ImageIcon greenRect2;
		
		public static ImageIcon purplerectangle;
		public static Image purpleRectImg;
		public static ImageIcon purpleRect;
		public static ImageIcon purpleRects;
		public static ImageIcon purpleRect2;
		
		public static ImageIcon yellowrectangle;
		public static Image yellowRectImg;
		public static ImageIcon yellowRect;
		public static ImageIcon yellowRects;
		public static ImageIcon yellowRect2;
		
		public static ImageIcon blackrectangle;
		public static Image blackRectImg;
		public static ImageIcon blackRect;
		public static ImageIcon blackRects;
		public static ImageIcon blackRect2;
		
		public static ImageIcon orangerectangle;
		public static Image orangeRectImg;
		public static ImageIcon orangeRect;
		public static ImageIcon orangeRects;
		public static ImageIcon orangeRect2;
		
		public static ImageIcon blackCircle1;
		public static Image blackCircleImg;
		public static ImageIcon blackCircles1;
		public static ImageIcon blackCircles2;
		public static ImageIcon blackCircles3;
		
		public static ArrayList<rectangle> ink;
		
		public static int xPos;
		public static int yPos;
		public static int color = 0;
		
		public static boolean isDrawing = false;
		public static boolean isErasing = false;
		
		public static boolean isSmall = false;
		
		public static void main(String args[]) 
		{
			bluerectangle = new ImageIcon("bluee.png");
			blueRectImg = bluerectangle.getImage();
			blueRect = new ImageIcon(blueRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			blueRects = new ImageIcon(blueRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			blueRect2 = new ImageIcon(blueRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			purplerectangle = new ImageIcon("purplee.jpg");
			purpleRectImg = purplerectangle.getImage();
			purpleRect = new ImageIcon(purpleRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			purpleRects = new ImageIcon(purpleRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			purpleRect2 = new ImageIcon(purpleRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			greenrectangle = new ImageIcon("greenn.png");
			greenRectImg = greenrectangle.getImage();
			greenRect = new ImageIcon(greenRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			greenRects = new ImageIcon(greenRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			greenRect2 = new ImageIcon(greenRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			orangerectangle = new ImageIcon("orange.jpg");
			orangeRectImg = orangerectangle.getImage();
			orangeRect = new ImageIcon(orangeRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			orangeRects = new ImageIcon(orangeRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			orangeRect2 = new ImageIcon(orangeRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			redrectangle = new ImageIcon("redd.jpg");
			redRectImg = redrectangle.getImage();
			redRect = new ImageIcon(redRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			redRects = new ImageIcon(redRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			redRect2 = new ImageIcon(redRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			yellowrectangle = new ImageIcon("yellow.jpg");
			yellowRectImg = yellowrectangle.getImage();
			yellowRect = new ImageIcon(yellowRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			yellowRects = new ImageIcon(yellowRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			yellowRect2 = new ImageIcon(yellowRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			brownrectangle = new ImageIcon("brown.png");
			brownRectImg = brownrectangle.getImage();
			brownRect = new ImageIcon(brownRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
			brownRects = new ImageIcon(brownRectImg.getScaledInstance(6, 6, java.awt.Image.SCALE_SMOOTH));
			brownRect2 = new ImageIcon(brownRectImg.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH));
			
			blackCircle1 = new ImageIcon("blackCircle.png");
			blackCircleImg = blackCircle1.getImage();
			blackCircles1 = new ImageIcon(blackCircleImg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
			blackCircles2 = new ImageIcon(blackCircleImg.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
			blackCircles3 = new ImageIcon(blackCircleImg.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH));
			
			xPos = 0;
			yPos = 0;
			
			ink = new ArrayList<rectangle>();
			
			mainframe = new JFrame();
			
			mainframe.setTitle("Drawing Board");
			mainframe.setSize(600, 700);
			mainframe.getContentPane().setBackground(Color.WHITE);
			mainframe.setLocationRelativeTo(null);
			mainframe.setLayout(null);
			mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainframe.setVisible(true);
			
			mainframe.getContentPane().addMouseListener(new MouseAdapter() {            
		    	   @Override
		    	   public void mouseClicked(MouseEvent e) {
		    		  
		    		   
		    		   if (isDrawing == false)
		    		   {
		    			   isDrawing = true;
		    		   }
		    		   else if (isDrawing)
		    		   {
		    			   isDrawing = false;
		    		   }
		    		   
		   
		    		   if (isErasing)
		    		   {
		    			   /* int xPos = MouseInfo.getPointerInfo().getLocation().x;
			    		   int yPos = MouseInfo.getPointerInfo().getLocation().y;
							
							xPos -= 420;
							yPos -=105;
							
							System.out.println(xPos);
							System.out.println(ink.get(ink.size()-1).getX());
							
							System.out.println(yPos);
							System.out.println(ink.get(ink.size()-1).getY()); */
		    			   
		    			   isErasing = false;
		    		   }
		    	   }
		    	});
			
			JLabel title = new JLabel("Drawing Board");
			title.setBounds(0, 0, 600, 50);
			title.setText("Drawing Board");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setForeground(Color.BLUE);
			title.setFont(new Font("A", Font.PLAIN, 40));
			title.setVisible(true);
			title.setFocusable(true);
			
			mainframe.add(title);
			mainframe.repaint();
			
			boardv1 = new ImageIcon("3348689-200.png");
			boardImg = boardv1.getImage();
			board = new ImageIcon(boardImg.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH));
			
			/* JLabel drawingBoard = new JLabel(board);
			drawingBoard.setBounds(0, 50, 600, 600);
			drawingBoard.setVisible(true);
			mainframe.add(drawingBoard);
			mainframe.repaint(); */
			
			drawRect(0,50, 600, 10);
			drawRect(0, 60, 10, 500);
			drawRect(10, 550, 600, 10);
			drawRect(590, 60, 10, 500);

			 JButton eraseAll = new JButton();
			 eraseAll.setText("Erase All");
			 eraseAll.setForeground(Color.GREEN);
			 eraseAll.setBackground(Color.BLUE);
			 eraseAll.setBorderPainted(false);
			 eraseAll.setOpaque(true);
			 eraseAll.setFont(new Font("Start Game", Font.PLAIN, 20));
			 eraseAll.setBounds(400, 620, 140, 30);
			 eraseAll.setVisible(true);
			 
			 JButton brownIcon = new JButton(brownRect2);
			 brownIcon.setBounds(50, 580, 15, 15);
			 brownIcon.setVisible(true);
			 mainframe.add(brownIcon);
			 mainframe.repaint();
			 
			 JButton blueIcon = new JButton(blueRect2);
			 blueIcon.setBounds(50, 600, 15, 15);
			 blueIcon.setVisible(true);
			 mainframe.add(blueIcon);
			 mainframe.repaint();
			 
			 JButton purpleIcon = new JButton(purpleRect2);
			 purpleIcon.setBounds(140, 580, 15, 15);
			 purpleIcon.setVisible(true);
			 mainframe.add(purpleIcon);
			 mainframe.repaint();
			 
			 JButton redIcon = new JButton(redRect2);
			 redIcon.setBounds(140, 600, 15, 15);
			 redIcon.setVisible(true);
			 mainframe.add(redIcon);
			 mainframe.repaint();
			 
			 JButton blackIcon = new JButton(blackRect);
			 blackIcon.setBounds(80, 580, 15, 15);
			 blackIcon.setVisible(true);
			 mainframe.add(blackIcon);
			 mainframe.repaint();
			 
			 JButton greenIcon = new JButton(greenRect2);
			 greenIcon.setBounds(80, 600, 15, 15);
			 greenIcon.setVisible(true);
			 mainframe.add(greenIcon);
			 mainframe.repaint();
			 
			 JButton yellowIcon = new JButton(yellowRect2);
			 yellowIcon.setBounds(110, 580, 15, 15);
			 yellowIcon.setVisible(true);
			 mainframe.add(yellowIcon);
			 mainframe.repaint();
			 
			 JButton orangeIcon = new JButton(orangeRect2);
			 orangeIcon.setBounds(110, 600, 15, 15);
			 orangeIcon.setVisible(true);
			 mainframe.add(orangeIcon);
			 mainframe.repaint();
			 
			 JButton blackCircleb = new JButton(blackCircles1);
			 blackCircleb.setBounds(180, 600, 20, 20);
			 blackCircleb.setVisible(true);
			 mainframe.add(blackCircleb);
			 mainframe.repaint();
			 
			 JButton blackCirclebb = new JButton(blackCircles2);
			 blackCirclebb.setBounds(220, 598, 25, 25);
			 blackCirclebb.setVisible(true);
			 mainframe.add(blackCirclebb);
			 mainframe.repaint();
			 
			 blackCirclebb.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	isSmall = false;
			        	
			        }
			    });
			 
			 blackCircleb.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	isSmall = true;
			        	
			        }
			    });
			 
			 
			 brownIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 1;
			        	
			        }
			    });
			 
			 blackIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 0;
			        	
			        }
			    });
			 
			 orangeIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 2;
			        	
			        }
			    });
			 
		    yellowIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 3;
			        	
			        }
			    });
			 
			 redIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	
			        	color = 4;
			        }
			    });
			 
			 purpleIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 5;
			        	
			        }
			    });
			 
			 greenIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 6;
			        	
			        }
			    });
			 blueIcon.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	color = 7;
			        	
			        }
			    });
			
			 
			 JButton erase = new JButton();
			 erase.setText("Erase");
			 erase.setForeground(Color.GREEN);
			 erase.setBackground(Color.BLUE);
			 erase.setBorderPainted(false);
			 erase.setOpaque(true);
			 erase.setFont(new Font("Start Game", Font.PLAIN, 20));
			 erase.setBounds(400, 580, 140, 30);
			 erase.setVisible(true);
			 
			 mainframe.add(eraseAll);
			 erase.setFocusable(true);
			 mainframe.repaint();
			 
			 
			 mainframe.add(erase);
			 erase.setFocusable(true);
			 mainframe.repaint();
			 
			 erase.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	isErasing = true;
			        	
			        }
			    });
			 
			 eraseAll.addActionListener(new ActionListener(){  
			        public void actionPerformed(ActionEvent e){
			        	
			        	for (int i = 0; i < ink.size(); i++)
			        	{
			        		ink.get(i).setVisible(false);
			        	}
			        	
			        }
			    });
			 
			 while (true)
			 {
				 try {
						Thread.sleep(5);
						
						int currentX;
						int currentY;
						
						currentX = MouseInfo.getPointerInfo().getLocation().x;
						currentY = MouseInfo.getPointerInfo().getLocation().y;
						
						if (currentX == xPos)
						{
							if (currentY == yPos)
							{
								continue;
							}
						}
						
						if (currentX < 430)
						{
							continue;
						}
						
						if (currentX > 1000)
						{
							continue;
						}
						
						if (currentY < 160)
						{
							continue;
						}
						
						if (currentY > 650)
						{
							continue;
						}
						
						int xStart = currentX - 4;
						int yStart = currentY - 4;
						
						xStart -= 420;
						yStart -=105;
						
						if (isErasing == true)
						{
							int xPos = MouseInfo.getPointerInfo().getLocation().x;
							int yPos = MouseInfo.getPointerInfo().getLocation().y;
							
							xPos -= 420;
							yPos -=105;
							
							/* System.out.println(xPos);
							System.out.println(ink.get(ink.size()-1).getX());
							
							System.out.println(xPos);
							System.out.println(ink.get(ink.size()-1).getX()); */
							
							for (int index = 0; index < ink.size(); index++)
							{
								for (int x = ink.get(index).getX(); x < ink.get(index).getX() + 8; x++)
								{
									for (int y = ink.get(index).getY(); y < ink.get(index).getY() + 8; y++)
									{
										// System.out.println(x + " " + xPos);
										if (x >= xPos && x < xPos + 8)
										{
											// System.out.println("X is the same");
											if (y >= yPos && y < yPos + 8)
											{
												ink.get(index).setVisible(false);
												/* System.out.println("Y is the same");
												if (index < ink.size() -1)
												{
													System.out.println("1");
													ink.remove(index);
													index--;
												}
												else
												{
													System.out.println("2");
													ink.remove(index);
												} */
											  	
											}
										}
									}
								}
							}
						}
						
						if (isDrawing == true)
						{
							drawRect2(xStart, yStart);
						}
						
						// System.out.println(MouseInfo.getPointerInfo().getLocation().y);
						// System.out.println(MouseInfo.getPointerInfo().getLocation().x);
						
						xPos = currentX;
						yPos = currentY;
						
				 } catch (InterruptedException e) {
						e.printStackTrace();
					}}
				 
			 }
		
		public static void drawRect(int a, int b, int c, int d)
		{
			blackrectangle = new ImageIcon("brectangle.png");
			blackRectImg = blackrectangle.getImage();
			blackRect = new ImageIcon(blackRectImg.getScaledInstance(c, d, java.awt.Image.SCALE_SMOOTH));
			
			JLabel rect = new JLabel(blackRect);
			rect.setBounds(a, b, c, d);
			rect.setVisible(true);
			mainframe.add(rect);
			mainframe.repaint();
		}
		
		public static void drawRect2(int a, int b)
		{
			/* blackrectangle = new ImageIcon("brectangle.png");
			blackRectImg = blackrectangle.getImage();
			blackRect = new ImageIcon(blackRectImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH)); */
			
			rectangle rect = new rectangle(blackRect, a, b);
			
			if (color == 0)
			{
				rect = new rectangle(blackRect, a, b);
			}
			else if (color == 1)
			{
				rect = new rectangle(brownRect, a, b);
			}
			else if (color == 2)
			{
				rect = new rectangle(orangeRect, a, b);
			}
			else if (color == 3)
			{
				rect = new rectangle(yellowRect, a, b);
			}
			else if (color == 4)
			{
				rect = new rectangle(redRect, a, b);
			}
			else if (color == 5)
			{
				rect = new rectangle(purpleRect, a, b);
			}
			else if (color == 6)
			{
				rect = new rectangle(greenRect, a, b);
			}
			else if (color == 7) 
			{
				rect = new rectangle(blueRect, a, b);
			}
			
			if (isSmall == false)
			{
				rect.setBounds(a, b, 8, 8);
				rect.setVisible(true);
				mainframe.add(rect);
				mainframe.repaint();
			}
			else
			{
				rect.setBounds(a, b, 6, 6);
				rect.setVisible(true);
				mainframe.add(rect);
				mainframe.repaint();
			}
			
			ink.add(rect);
		}
		
}

class rectangle extends JLabel
{
	private int x;
	private int y;
	
	public rectangle(ImageIcon br, int a, int b)
	{
		super(br);
		x = a;
		y = b;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}