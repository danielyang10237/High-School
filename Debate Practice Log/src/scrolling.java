import java.awt.Color;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class scrolling extends mainRunner {

	public static JButton previousPage;
	public static JButton nextPage;
	private int pageNumber = 1;
	private int pageNumber2 = 1;
	
	public void scrollingRun()
	{
		System.out.println("hal");
		nextPage = new JButton();
		nextPage.setText("Next");
		nextPage.setForeground(Color.WHITE);
		nextPage.setBackground(Color.ORANGE);
		nextPage.setBorderPainted(false);
		nextPage.setOpaque(true);
		nextPage.setFont(new Font("Next", Font.PLAIN, 18));
		nextPage.setBounds(520, 730, 120, 30);
		nextPage.setVisible(true);
		frame.add(nextPage);
		nextPage.setFocusable(true);
		frame.repaint();
		
		previousPage = new JButton();
		previousPage.setText("Previous");
		previousPage.setForeground(Color.WHITE);
		previousPage.setBackground(Color.ORANGE);
		previousPage.setBorderPainted(false);
		previousPage.setOpaque(true);
		previousPage.setFont(new Font("Previous", Font.PLAIN, 18));
		previousPage.setBounds(300, 730, 120, 30);
		previousPage.setVisible(true);
		frame.add(previousPage);
		previousPage.setFocusable(true);
		frame.repaint();
		
		nextPage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("here");
				if (firstPage == true)
				{
					if (pageNumber < (names.size() / 10 + 1))
					{
						pageNumber++;
						updateMembers();
						System.out.println("here");
					}
				}
				else
				{
					//System.out.println("here1");
					if (pageNumber2 < (totalDebaters.size() / 10 + 1))
					{
						pageNumber2++;
						updateReport();
					}
				}
			}
		});
		
		previousPage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (firstPage == true)
				{
					if (pageNumber > 1)
					{
						pageNumber--;
						updateMembers();
					}
				}
				else
				{
					//System.out.println("here2");
					if (pageNumber2 > 1)
					{
						pageNumber2--;
						updateReport();
					}
				}
			}
		});
		
	}
	
	public void updateReport()
	{
		ArrayList<Integer> met;
		met = new ArrayList<Integer>();
		
		for (int i = 0; i < backgrounds.size(); i++)
		{
			backgrounds.get(i).setVisible(false);
			backgrounds.remove(i);
			i--;
		}
		
		String students = "<html>";
		String studentsT = "<html>";
		int count = 0;
		int count2 = 0;
		
		if (totalDebaters.size() <= 14 && pageNumber2 == 1)
		{
			//System.out.print(totalDebaters.size() + " 11111");
			for (int i = 0; i < totalDebaters.size(); i++)
			{
				students = students + "" + totalDebaters.get(i).getName() + "<br/>";
				studentsT = studentsT + "" + totalDebaters.get(i).getDuration() + "<br/>";
				count++;
				count2++;
				
				boolean requirement = totalDebaters.get(i).getReq();
				System.out.println(requirement);
				
				if (requirement == true)
				{
					System.out.println("gfGDgdfgdfg");
					int x = i + 1;
					met.add(x);
				}
			}
			for (int j = 0; j < 14 - count; j++)
			{
				students = students + "<br/>";
				studentsT = studentsT + "<br/>";
			}
		}
		else if (totalDebaters.size() >= 14 && pageNumber2 == 1)
		{
			//System.out.print(totalDebaters.size() + " 2222");
			for (int i = 0; i < 14; i++)
			{
				boolean requirement = totalDebaters.get(i).getReq();
				System.out.println(requirement);
				
				if (requirement == true)
				{
					// System.out.println("gfGDgdfgdfg");
					int x = i + 1;
					met.add(x);
				}
				students = students + "" + totalDebaters.get(i).getName() + "<br/>";
				studentsT = studentsT + "" + totalDebaters.get(i).getDuration() + "<br/>";
				count++;
				count2++;
			}
		}
		else if (totalDebaters.size() >= 14 && pageNumber2 > 1)
		{
			// System.out.println("yoov");
			
			int start = ((int) (pageNumber2 - 1)) * 14;
			int counter = 0;
			
			int interval = 14;
			if (totalDebaters.size() / 14 + 1 == pageNumber2 && totalDebaters.size() % 14 != 0)
			{
				interval = totalDebaters.size() % 14;
			}
			if (interval == 0)
			{
				interval = 14;
			}
			for (int x = start; x < start + interval; x++)
			{
				counter++;
				
				if (x < totalDebaters.size())
				{
				students = students + "" + totalDebaters.get(x).getName() + "<br/>";
				
				boolean requirement = totalDebaters.get(x).getReq();
				System.out.println(requirement);
				
				if (requirement == true)
				{
					// System.out.println("gfGDgdfgdfg");
					met.add(counter);
				}
				
				studentsT = studentsT + "" + totalDebaters.get(x).getDuration() + "<br/>";
				}
				count++;
				count2++;
				
			}
			for (int j = 0; j < 14 - interval; j++)
			{
				students = students + "<br/>";
				studentsT = studentsT + "<br/>";
			}
			
		}
		else
		{
			System.out.print(totalDebaters.size() + " hihihih");
		}
		
		for (int j = 0; j < count; j++)
		{
			if (met.contains(j) == true)
			{
				JLabel highlight = new JLabel(green);
				int y = 185;
				y = y + 36 * j;
				highlight.setBounds(0, y, 25, 25);
				highlight.setVisible(true);
				frame.add(highlight);
				frame.repaint();
				backgrounds3.add(highlight);
			}
			else
			{
				JLabel highlight = new JLabel(red);
				int y = 185;
				y = y + 36 * j;
				highlight.setBounds(0, y, 25, 25);
				highlight.setVisible(true);
				frame.add(highlight);
				frame.repaint();
				backgrounds3.add(highlight);
			}
		} 
		
		/* for (int j = 0; j < met.size(); j++)
		{
			// System.out.println("here");
			// System.out.println(index.get(j));
			JLabel highlight = new JLabel(green);
			int y = 185;
			y = y + 36 * (met.get(j) - 1);
			highlight.setBounds(0, y, 25, 25);
			highlight.setVisible(true);
			frame.add(highlight);
			frame.repaint();
			backgrounds3.add(highlight);
		} */
		
		studentReport.setText(students);
		timeReport.setText(studentsT);
		
		int x = 0;
		if (count2 % 2 == 1)
		{
			x = count2 / 2 + 1;
		}
		else
		{
			x = count2 / 2;
		}
		
		// System.out.println("wooo " + x);
		int pageIndex = 180;
		for (int v = 0; v < x; v++)
		{
			JLabel highlight = new JLabel(gray);
			highlight.setBounds(0, pageIndex, 1000, 36);
			highlight.setVisible(true);
			frame.add(highlight);
			frame.repaint();
			
			backgrounds.add(highlight);
			pageIndex += 72; 
		}
	}
	
	public int getPage()
	{
		return pageNumber;
	}
	
}
