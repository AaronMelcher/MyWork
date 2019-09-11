package emailMerge;

import java.util.*;
import java.io.*;

/**
 * Generates a set of .txt files based on what is in the people.txt file using the template.txt file to create an email.
 * 
 * @author Aaron Melcher
 *
 */

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		//Creates both scanners without need to close them
		try (Scanner input = new Scanner(new File("src/emailMerge/template.txt"));
				Scanner input2 = new Scanner(new File("src/emailMerge/people.txt"))) {
			String temp = new String();

			//Reads out the lines in the template
			while (input.hasNextLine())
				temp += input.nextLine() + "\n";
			
			//Replaces the specified spaces for name, age, and gender
			//Runs through each person, and creates .txt files based on the number of people in the people.txt file
			while (input2.hasNextLine()) {
				String[] info = input2.nextLine().split(" ");
				String message = temp.replaceAll("<<N>>,", info[0]).replaceAll("<<A>>", info[1]).replaceAll("<<G>>,", info[2]);

				File file = new File(info[0] + ".txt");

				if (!file.createNewFile())
					for (int i = 1; !file.createNewFile(); i++)
						file = new File(info[0] + "-" + i + ".txt");
				try (PrintWriter output = new PrintWriter(file)) {
					output.println(message);
				}

			}
		}
	}
}
