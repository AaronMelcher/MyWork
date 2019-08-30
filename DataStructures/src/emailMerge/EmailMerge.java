package emailMerge;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		File template = new File("src/emailMerge/template.txt");
		Scanner input = new Scanner(template);
		String[] words = input.nextLine().split(" ");
		
		for(String temp : words) {
			System.out.println(temp);
		}
		input.close();
	}
}
