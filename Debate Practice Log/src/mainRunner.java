import java.awt.Color;




import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class mainRunner {
	
	public static ImageIcon grayv1;
	public static Image grayImg;
	public static ImageIcon gray;
	
	public static ImageIcon yellowv1;
	public static Image yellowImg;
	public static ImageIcon yellow;
	
	public static ImageIcon greenv1;
	public static Image greenImg;
	public static ImageIcon green;
	
	public static ImageIcon redv1;
	public static Image redImg;
	public static ImageIcon red;
	
	public static JFrame frame;
	
	public static JLabel result;
	public static JLabel loggedMembers;
	public static JLabel loggedMembersTitle;
	public static JLabel studentTitle;
	public static JLabel studentTime;
	public static JLabel studentReport;
	public static JLabel timeReport;
	
	public static JButton getReport;
	public static JButton goBack;
	public static JButton notCheckedOut;
	
	public static scrolling s;
	
	public static int minRequirement = 60;
	
	public static boolean firstMenu = true;
	public static boolean firstPage = true;
	
	public static ArrayList<String> names;
	public static ArrayList<String> missingTime;
	public static ArrayList<student> debaters;
	public static ArrayList<student> totalDebaters;
	public static ArrayList<String> officers;
	public static ArrayList<JLabel> reports;
	public static ArrayList<JLabel> backgrounds;
	public static ArrayList<JLabel> backgrounds2;
	public static ArrayList<JLabel> backgrounds3;
	
	public static void main(String[] args)
	{
		grayv1 = new ImageIcon("lightgray.png");
		grayImg = grayv1.getImage();
		gray = new ImageIcon(grayImg.getScaledInstance(1000, 36, java.awt.Image.SCALE_SMOOTH));
		
		yellowv1 = new ImageIcon("yellow.jpg");
		yellowImg = yellowv1.getImage();
		yellow = new ImageIcon(yellowImg.getScaledInstance(1000, 36, java.awt.Image.SCALE_SMOOTH));
		
		greenv1 = new ImageIcon("checkmark.png");
		greenImg = greenv1.getImage();
		green = new ImageIcon(greenImg.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
		
		redv1 = new ImageIcon("red.png");
		redImg = redv1.getImage();
		red = new ImageIcon(redImg.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
		
		frame = new JFrame();
		
		s = new scrolling();
		s.scrollingRun();
		
		names = new ArrayList<String>();
		missingTime = new ArrayList<String>();
		officers = new ArrayList<String>();
		debaters = new ArrayList<student>();
		totalDebaters = new ArrayList<student>();
		reports = new ArrayList<JLabel>();
		backgrounds = new ArrayList<JLabel>();
		backgrounds2 = new ArrayList<JLabel>();
		backgrounds3 = new ArrayList<JLabel>();
		
		studentTitle = new JLabel();
		studentTime = new JLabel();
		studentReport = new JLabel();
		timeReport = new JLabel();
		
		frame.setTitle("Debate Hours Logger");
		frame.setSize(1000, 1000);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
        
	 
		JLabel title = new JLabel();
		title.setText("Debate Practice Logger");
	    title.setForeground(Color.BLUE);
	    title.setBounds(330, 30, 400, 40);
		title.setFont(new Font("Hangman", Font.PLAIN, 30));
	    title.setVisible(true);
	    title.setFocusable(true);
	    frame.add(title);
	    frame.repaint();
	    
	    result = new JLabel(" ", SwingConstants.CENTER);
	    // result.setText(" ", SwingConstants.CENTER);
	    result.setForeground(Color.BLUE);
	    result.setBounds(0, 150, 1000, 40);
	    result.setFont(new Font("Hangman", Font.PLAIN, 20));
	    result.setVisible(true);
	    result.setFocusable(true);
	    frame.add(result);
	    frame.repaint();
	    
	    loggedMembers = new JLabel(" ", SwingConstants.CENTER);
	    // result.setText(" ", SwingConstants.CENTER);
	    loggedMembers.setForeground(Color.BLUE);
	    loggedMembers.setBounds(0, 350, 1000, 400);
	    loggedMembers.setFont(new Font("Hangman", Font.PLAIN, 20));
	    loggedMembers.setVisible(true);
	    loggedMembers.setFocusable(true);
	    frame.add(loggedMembers);
	    frame.repaint();
	    
	    loggedMembersTitle = new JLabel("Members Currently Logged In", SwingConstants.CENTER);
	    // result.setText(" ", SwingConstants.CENTER);
	    loggedMembersTitle.setForeground(Color.BLUE);
	    loggedMembersTitle.setBounds(0, 380, 1000, 40);
	    loggedMembersTitle.setFont(new Font("Hangman", Font.PLAIN, 30));
	    loggedMembersTitle.setVisible(true);
	    loggedMembersTitle.setFocusable(true);
	    frame.add(loggedMembersTitle);
	    frame.repaint();
	    
	    JLabel info = new JLabel();
	    info.setText("Enter name to check student in or out");
	    info.setForeground(Color.BLUE);
	    info.setBounds(320, 80, 600, 60);
	    info.setFont(new Font("Hangman", Font.PLAIN, 20));
	    info.setVisible(true);
	    info.setFocusable(true);
	    frame.add(info);
	    frame.repaint();
	    
	    JTextField enterFirst = new JTextField("Enter First Name");
	    enterFirst.setBounds(250, 230, 200, 50);
	    enterFirst.setVisible(true);
	    enterFirst.setFocusable(true);
		frame.add(enterFirst);
		frame.repaint();
		
		JTextField enterRequirement = new JTextField("Enter in Minutes");
		enterRequirement.setBounds(520, 300, 200, 50);
		enterRequirement.setVisible(true);
		enterRequirement.setFocusable(true);
		frame.add(enterRequirement);
		frame.repaint();
		
		
		JTextField enterLast = new JTextField("Enter Last Name");
		enterLast.setBounds(540, 300, 200, 50);
		enterLast.setVisible(false);
		enterLast.setFocusable(true);
		frame.add(enterLast);
		frame.repaint();
		
		JLabel reqInfo = new JLabel();
		reqInfo.setText("Enter hour requirement:");
		reqInfo .setForeground(Color.RED);
		reqInfo .setBounds(270, 300, 250, 50);
		reqInfo .setFont(new Font("Enter hour requirement:", Font.PLAIN, 18));
		reqInfo .setVisible(true);
	    reqInfo .setFocusable(true);
	    frame.add(reqInfo);
	    frame.repaint();
		
		getReport = new JButton();
		getReport.setText("Get Report");
		getReport.setForeground(Color.WHITE);
		getReport.setBackground(Color.GREEN);
		getReport.setBorderPainted(false);
		getReport.setOpaque(true);
		getReport.setFont(new Font("Get Report", Font.PLAIN, 22));
		getReport.setBounds(540, 230, 200, 50);
		getReport.setVisible(true);
		frame.add(getReport);
		getReport.setFocusable(true);
		frame.repaint();
		
		goBack = new JButton();
		goBack.setText("Go Back");
		goBack.setForeground(Color.WHITE);
		goBack.setBackground(Color.GREEN);
		goBack.setBorderPainted(false);
		goBack.setOpaque(true);
		goBack.setFont(new Font("Get Report", Font.PLAIN, 22));
		goBack.setBounds(770, 90, 200, 50);
		goBack.setVisible(false);
		frame.add(goBack);
		getReport.setFocusable(true);
		frame.repaint();
		
		notCheckedOut = new JButton();
		notCheckedOut.setText("Not Checked Out");
		notCheckedOut.setForeground(Color.WHITE);
		notCheckedOut.setBackground(Color.GREEN);
		notCheckedOut.setBorderPainted(false);
		notCheckedOut.setOpaque(true);
		notCheckedOut.setFont(new Font("Get Report", Font.PLAIN, 16));
		notCheckedOut.setBounds(770, 20, 200, 50);
		notCheckedOut.setVisible(false);
		frame.add(notCheckedOut);
		notCheckedOut.setFocusable(true);
		frame.repaint();
		
		notCheckedOut.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				firstMenu = false;
				notCheckedOut.setVisible(false);
				
				studentTime.setVisible(false);
				timeReport.setVisible(false);
				
				studentTitle.setText("Students who have not checked out");
				studentTitle.setBounds(100, 100, 800, 40);
				studentReport.setBounds(100, 180, 800, 500);
				
				String output = "<html>";
				int count = 0;
				
				for (int i = 0; i < missingTime.size(); i++)
				{
					output = output + "" + missingTime.get(i) + "<br/>";
					count++;
				} 
				
				for (int j = 0; j < 22 - count; j++)
				{
					output = output + "<br/>";
				}
				
				studentReport.setText(output);
				
			}});
		
		goBack.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				for (int i = 0; i < backgrounds.size(); i++)
				{
					backgrounds.get(i).setVisible(false);
					backgrounds.remove(i);
					i--;
				}
				
				if (firstMenu== true)
				{
				
				firstPage = true;
				
				goBack.setVisible(false);
				notCheckedOut.setVisible(false);
					
				getReport.setVisible(false);
				
				result.setVisible(true);
				loggedMembers.setVisible(true);
				loggedMembersTitle.setVisible(true);
				getReport.setVisible(true);
				enterFirst.setVisible(true);
				enterRequirement.setVisible(true);
				reqInfo.setVisible(true);
				info.setVisible(true);
				title.setVisible(true);
				
				studentTitle.setVisible(false);
				studentTime.setVisible(false);
				studentReport.setVisible(false);
				timeReport.setVisible(false);
				}
				else
				{
					notCheckedOut.setVisible(true);
					firstMenu = true;
					
					studentTime.setVisible(true);
					timeReport.setVisible(true);
					
					studentTitle.setText("Student Names");
					studentTitle.setBounds(100, 100, 400, 20);
					studentReport.setBounds(100, 180, 400, 500);
					
					String students = "<html>";
					int count = 0;
					
					for (int i = 0; i < totalDebaters.size(); i++)
					{
						students = students + "" + totalDebaters.get(i).getName() + "<br/>";
						count++;
					}
					
					for (int j = 0; j < 22 - count; j++)
					{
						students = students + "<br/>";
					}
					
					studentReport.setText(students);
				}
			}
		});
		
		getReport.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				for (int i = 0; i < backgrounds2.size(); i++)
				{
					backgrounds2.get(i).setVisible(false);
					backgrounds2.remove(i);
					i--;
				}
				
				for (int i = 0; i < backgrounds3.size(); i++)
				{
					backgrounds3.get(i).setVisible(false);
					backgrounds3.remove(i);
					i--;
				}
				
				firstMenu = true;
				firstPage = false;
				
				goBack.setVisible(true);
				notCheckedOut.setVisible(true);
				
				result.setVisible(false);
				loggedMembers.setVisible(false);
				loggedMembersTitle.setVisible(false);
				getReport.setVisible(false);
				enterFirst.setVisible(false);
				enterRequirement.setVisible(false);
				reqInfo.setVisible(false);
				info.setVisible(false);
				title.setVisible(false);
				
				studentTitle.setText("Student Names");
				studentTitle.setForeground(Color.BLUE);
				studentTitle.setBounds(100, 100, 400, 40);
				studentTitle.setFont(new Font("Student Names", Font.PLAIN, 30));
				studentTitle.setVisible(true);
				studentTitle.setFocusable(true);
			    frame.add(studentTitle);
			    frame.repaint();
			    
			    studentTime.setText("Time Logged");
			    studentTime.setForeground(Color.BLUE);
			    studentTime.setBounds(500, 100, 400, 40);
			    studentTime.setFont(new Font("Student Names", Font.PLAIN, 30));
			    studentTime.setVisible(true);
			    studentTime.setFocusable(true);
			    frame.add(studentTime);
			    frame.repaint();
			    
			    studentReport.setText("B ");
			    studentReport.setForeground(Color.BLUE);
			    studentReport.setBounds(100, 180, 400, 500);
				studentReport.setFont(new Font(" ", Font.PLAIN, 30));
				studentReport.setVisible(true);
				studentReport.setFocusable(true);
			    frame.add(studentReport);
			    frame.repaint();
			    
			    timeReport.setText("B ");
			    timeReport.setForeground(Color.BLUE);
			    timeReport.setBounds(500, 180, 800, 500);
				timeReport.setFont(new Font(" ", Font.PLAIN, 30));
				timeReport.setVisible(true);
				timeReport.setFocusable(true);
			    frame.add(timeReport);
			    frame.repaint();
				
			    s.updateReport();
				
			}
		});
		
		enterRequirement.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String req = enterRequirement.getText();
				enterRequirement.setText(""); 
				
				int reqNum = Integer.parseInt(req);
				
				minRequirement = reqNum;
			}
		});
		
		enterFirst.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String firstName = enterFirst.getText();
				enterFirst.setText("");
				// enterLetters.setText("");
				
				long a = System.nanoTime();
				long b = System.nanoTime();
				// System.out.println(b-a);
				
				firstName = firstName.toLowerCase();
				boolean isBlank = false;
				if (firstName.equals(""))
				{
					isBlank = true;
				}
				
				if (names.contains(firstName))
				{
					// System.out.println("here");
					long firstTime = System.nanoTime();
					int position = names.indexOf(firstName);
					long secondTime = System.nanoTime();
					debaters.get(position).checkOut(secondTime);
					String time = debaters.get(position).getDuration();
					result.setText(firstName + " has stayed today for a total time of " + time);
					
					int index = names.indexOf(firstName);
					names.remove(index);
					debaters.remove(index); 
					missingTime.remove(firstName);
				}
				else if (firstName.equals("daniel"))
				{
					officers.add(firstName);
					
					result.setText("Officer has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setName(firstName);
					debater.setRequirement(minRequirement);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
					
				}
				else if (firstName.equals("zain"))
				{
					result.setText("Officer has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setName(firstName);
					debater.setRequirement(minRequirement);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
					
					officers.add(firstName);
				}
				else if (firstName.equals("caroline"))
				{
					result.setText("Officer has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setRequirement(minRequirement);
					debater.setName(firstName);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
					
					officers.add(firstName);
				}
				else if (firstName.equals("allie"))
				{
					result.setText("Officer has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setRequirement(minRequirement);
					debater.setName(firstName);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
					
					officers.add(firstName);
				}
				else if (firstName.equals("jawad"))
				{
					result.setText("Officer has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setRequirement(minRequirement);
					debater.setName(firstName);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
					
					officers.add(firstName);
				}
				else if (isBlank == false)
				{
					result.setText(firstName + " has been checked in");
					result.setForeground(Color.GREEN);
					long firstTime = System.nanoTime();
					// System.out.println(firstTime);
					student debater = new student();
					debater.checkIn(firstTime);
					debater.setName(firstName);
					debater.setRequirement(minRequirement);
					
					names.add(firstName);
					debaters.add(debater);
					totalDebaters.add(debater);
					missingTime.add(firstName);
				}
				
				updateMembers();
			}
		}); 
		
		
	}
	
	
	public static void updateMembers()
	{
		for (int i = 0; i < backgrounds2.size(); i++)
		{
			backgrounds2.get(i).setVisible(false);
			backgrounds2.remove(i);
			i--;
		}
		
		for (int i = 0; i < backgrounds3.size(); i++)
		{
			backgrounds3.get(i).setVisible(false);
			backgrounds3.remove(i);
			i--;
		}
		
		String display = "<html>";
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		int count2 = 0;
		int count3 = 0;
		if (names.size() < 10)
		{
			int count = 0;
		
			for (int i = 0; i < names.size(); i++)
			{
				count2++;
				for (int x = 0; x < officers.size(); x++)
				{
					// System.out.println(officers.get(x) + " - " + names.get(i));
					if (officers.get(x).equals(names.get(i)))
					{
						index.add(count2);
						/* JLabel highlight = new JLabel(yellow);
						int y = 425 + 25 * (count3 % 10);
						highlight.setBounds(0, y, 1000, 23);
						highlight.setVisible(true);
						frame.add(highlight);
						frame.repaint();
						backgrounds2.add(highlight); */
					}
				} 
				display = display + "" + names.get(i) + "<br/>";
				count++;
				count3++;
			}
		
			for (int j = 0; j < 10 - count; j++)
			{
				display = display + "<br/>";
			}
		
			display = display + "<html>";
		}
		else if (names.size() > 10 && s.getPage() == 1)
		{
			int count = 0;
		
			for (int i = 0; i < 10; i++)
			{
				display = display + "" + names.get(i) + "<br/>";
				count++;
				count2++;
				
				for (int x = 0; x < officers.size(); x++)
				{
					if (officers.get(x).equals(names.get(i)))
					{
						index.add(count2);
					}
				}
			}
		
			for (int j = 0; j < 10 - count; j++)
			{
				display = display + "<br/>";
			}
		
			display = display + "<html>";
		}
		else if (names.size() / 10 + 1 == s.getPage())
		{	
			int count = 0;
			int start = s.getPage();
			start = (start - 1) * 10;
			
			for (int i = start; i < start + names.size() % 10; i++)
			{
				display = display + "" + names.get(i) + "<br/>";
				count++;
				count2++;
				for (int x = 0; x < officers.size(); x++)
				{
					if (officers.get(x).equals(names.get(i)))
					{
						index.add(count2);
					}
				}
			}
		
			for (int j = 0; j < 10 - count; j++)
			{
				display = display + "<br/>";
			}
		}
		else
		{
			int start = s.getPage();
			start = (start - 1) * 10;
			
			for (int i = start; i < start + 10; i++)
			{
				count2++;
				display = display + "" + names.get(i) + "<br/>";
				for (int x = 0; x < officers.size(); x++)
				{
					if (officers.get(x).equals(names.get(i)))
					{
						index.add(count2);
					}
				}
			}
			
			
			display = display + "<html>";
		}
		
		/* int x = 0;
		if (count2 % 2 == 1)
		{
			x = count2 / 2 + 1;
		}
		else
		{
			x = count2 / 2;
		}

		int pageIndex1 = 430;
		for (int v = 0; v < x; v++)
		{
			System.out.println(x);
			JLabel highlight = new JLabel(gray);
			highlight.setBounds(0, pageIndex1, 1000, 23);
			highlight.setVisible(true);
			frame.add(highlight);
			frame.repaint();
			backgrounds2.add(highlight);
			
			pageIndex1 += 47; 
		} */
		
		 for (int j = 0; j < index.size(); j++)
		{
			System.out.println(index.get(j));
			JLabel highlight = new JLabel(yellow);
			int y = 400 + 25 * (index.get(j) % 10);
			highlight.setBounds(0, y, 1000, 23);
			highlight.setVisible(true);
			frame.add(highlight);
			frame.repaint();
			backgrounds2.add(highlight);
		} 
		
		loggedMembers.setText(display);
		
	}
	
	/* public static void destroy()
	{
		int count = 0;
		
		while (true)
		{
		
		count++;
		
		 try {
			Thread.sleep(16);
		} catch (InterruptedException e1) 
    		{
			// TODO Auto-generated catch block
    	} 
		
		if (count % 400 < 200)
		{
			result.setText(" ");
		}
		else
		{
			result.setText("ERROR INTEGER OVERFLOW");
		}
		
		
		}
	} */
}
