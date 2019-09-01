package emailMerge;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		File template = new File("src/emailMerge/template.txt");
		Scanner input = new Scanner(template);
		File people = new File("src/emailMerge/people.txt");
		Scanner input2 = new Scanner(people);
		String temp = new String();

		while (input.hasNextLine()) {
			temp += input.nextLine() + " ";
		}

		String[] words = temp.split(" ");
		ArrayList<String> names = new ArrayList<String>();
		do {
			String info = input.nextLine();
			
		} while (input2.hasNext());

		input.close();
	}
}
