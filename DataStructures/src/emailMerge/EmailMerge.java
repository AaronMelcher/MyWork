package emailMerge;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		try (Scanner input = new Scanner(new File("src/emailMerge/template.txt"));
				Scanner input2 = new Scanner(new File("src/emailMerge/people.txt"))) {
			String temp = new String();

			while (input.hasNextLine())
				temp += input.nextLine() + "\n";

			while (input2.hasNextLine()) {
				String[] info = input.nextLine().split(" ");
				String message = temp.replaceAll("<<N>>,", info[0]).replaceAll("<<A>>", info[1]).replaceAll("<<G>>,",
						info[2]);

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
