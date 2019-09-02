package emailMerge;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("src/emailMerge/template.txt"));
		Scanner input2 = new Scanner(new File("src/emailMerge/people.txt"));
		String temp = new String();

		while (input.hasNextLine()) {
			temp += input.nextLine() + " ";
		}

		String[] words = temp.split(" ");
		ArrayList<String> names = new ArrayList<String>();

		while (input2.hasNext()) {
			String[] fin = new String[words.length];
			String[] info = input.nextLine().split(" ");
			names.add(info[0]);
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("<<N>>,")) {
					fin[i] = info[0];
				} else if (words[i].equals("<<A>>")) {
					fin[i] = info[1];
				} else if (words[i].equals("<<G>>,")) {
					fin[i] = info[2];
				} else {
					fin[i] = words[i];
				}
			}
			
			
		}

		input.close();
		input2.close();
	}
}
