import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Encrypt {
	public static void main(String[] args) throws FileNotFoundException
	 {
		Scanner file = new Scanner(new File("gift.dat"));
		int numOfProtocols = file.nextInt();
		file.nextLine();
		for (int i = 0; i < numOfProtocols; i ++)
		{
			System.out.println("Protocol " + (i+1));
			String temp = file.nextLine();
			String protocol = temp.substring(0, 26);
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String capitalAlphabet = "ABCEDEFGHIJKLMNOPQRSTUVQXYZ !1234567890";
			int shift = Integer.parseInt(temp.substring(27));
			int lines = file.nextInt();
			file.nextLine();
			for (int j = 0; j < lines; j++)
			{
				String temp2 = file.nextLine();
				char action = temp2.charAt(0);
				String message = temp2.substring(2);
				String finalMessage = "";
				if (action == 'E')
				{
					for (int x = 0; x < message.length(); x ++)
					{
						String capital = message.substring(x, x+1);
						if (capitalAlphabet.indexOf(capital) > 0)
						{
							finalMessage = finalMessage + "" + capital;
						}
						else
						{
							int index = alphabet.indexOf(message.substring(x, x+1));
							String newLetter = protocol.substring(index, index+1);
							int newLetterIndex = alphabet.indexOf(newLetter);
							if ((newLetterIndex + shift) > 0)
							{
								finalMessage = finalMessage + "" + alphabet.charAt((newLetterIndex + shift)% 26);
							}
							else
							{
								finalMessage = finalMessage + "" + alphabet.charAt(26 - Math.abs(newLetterIndex + shift));
							}
						}
					}
				}
				else if (action == 'D')
				{
					for (int x = 0; x < message.length(); x ++)
					{
						String capital = message.substring(x, x+1);
						if (capitalAlphabet.indexOf(capital) > 0)
						{
							finalMessage = finalMessage + "" + capital;
						}
						else
						{
							int index = alphabet.indexOf(message.substring(x, x+1));
							int finalIndex = index - shift;
							if (finalIndex > 0)
							{
								String letter = alphabet.substring(finalIndex, finalIndex + 1);
								int finalfinalIndex = protocol.indexOf(letter);
								finalMessage = finalMessage + alphabet.substring(finalfinalIndex, finalfinalIndex + 1);
							}
							else 
							{
								finalIndex = 26 - finalIndex;
								String letter = alphabet.substring(finalIndex, finalIndex + 1);
								int finalfinalIndex = protocol.indexOf(letter);
								finalMessage = finalMessage + alphabet.substring(finalfinalIndex, finalfinalIndex + 1);
							}
						}
					}
				}
				else
				{
					System.out.println("failed");
				}
				System.out.println(finalMessage);
			}
		}
	 }
}
